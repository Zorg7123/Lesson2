package GameApp;

import java.util.Random;
import java.util.Scanner;

public class Game {public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    public static char[][] map;
    public static char[][] invisibleMap;
    public static int mapWidth;
    public static int mapHeight;
    public static int mapSizeMin = 3;
    public static int mapSizeMax = 3;
    public static int currentLevel = 0;

    public static char readyCell = '*';
    public static char emptyCell = '_';

    public static char player = '@';
    public static int playerHealth = 100;
    public static int playerAttackPoint = 10;
    public static int playerPositionX;
    public static int playerPositionY;
    public static final int playerStepUp = 8;
    public static final int playerStepLeft = 4;
    public static final int playerStepRight = 6;
    public static final int playerStepDown = 2;

    public static char enemy = 'E';
    public static int enemyHealth;
    public static int enemyAttackPoint;
    public static int enemyValueMin = 5;
    public static int enemyValueMax = 10;

    public static void main(String[] args) {

        while (isPlayerAlive()) {
            ++currentLevel;
            System.out.println("===== START LEVEL " + currentLevel + " =====");
            mapCycle();
        }
        System.out.println("===== GAME OVER! Count ready level " + currentLevel + " =====");
    }

    public static void mapCycle() {
        createMap();
        createPlayer();
        createEnemies();

        while (true) {
            showMap();
            changePositionPlayer();

            if (!isPlayerAlive()) {
                System.out.println("Player is dead!");
                break;
            }

            if (isFullMap()) {
                System.out.println("Map is full. End Level");
                break;
            }
        }
    }

    public static void changePositionPlayer() {
        int currentX = playerPositionX;
        int currentY = playerPositionY;

        int playerMove;

        do {
            System.out.print("Please write your move: (UP = " + playerStepUp +
                    ", LEFT = " + playerStepLeft +
                    ", RIGHT = " + playerStepRight +
                    ", DOWN = " + playerStepDown + ") >>> ");
            playerMove = scanner.nextInt();

            switch (playerMove) {
                case playerStepUp:
                    playerPositionY -= 1;
                    break;
                case playerStepLeft:
                    playerPositionX -= 1;
                    break;
                case playerStepRight:
                    playerPositionX += 1;
                    break;
                case playerStepDown:
                    playerPositionY += 1;
                    break;
            }
        } while (!isValidPlayerStep(currentX, currentY, playerPositionX, playerPositionY));

        playerNextMoveAction(currentX, currentY, playerPositionX, playerPositionY);
    }

    public static void playerNextMoveAction(int currentX, int currentY, int nextX, int nextY) {
        if (invisibleMap[nextY][nextX] == enemy) {
//            playerHealth -= enemyAttackPoint;
//            System.out.println("Alarm! Enemy give damage " + enemyAttackPoint + ". Player health now is " + playerHealth + "!");
            battle();
        }

        map[currentY][currentX] = readyCell;
        map[nextY][nextX] = player;
        invisibleMap[nextY][nextX] = emptyCell;
    }

    public static void battle() {
        int battleRoundCount = 1;
        int currentEnemyHealth = enemyHealth;

        System.out.println("=== START BATTLE ===");

        while (playerHealth > 0 && currentEnemyHealth > 0) {
            System.out.println("=== ROUND BATTLE " + battleRoundCount + " ===");
            System.out.println("PlayerHP: " + playerHealth + " PlayerAtk: " + playerAttackPoint);
            System.out.println("EnemyHP: " + currentEnemyHealth + " EnemyAtk: " + enemyAttackPoint);
            currentEnemyHealth -= playerAttackPoint;
            System.out.println("Player give damage to Enemy. Enemy HP is " + currentEnemyHealth);
            playerHealth -= enemyAttackPoint;
            System.out.println("Enemy give damage to Player. Player HP is " + playerHealth);
            battleRoundCount++;
        }

        System.out.println("=== END BATTLE ===");
    }

    public static boolean isValidPlayerStep(int currentX, int currentY, int nextX, int nextY) {
        if (nextX >= 0 && nextX < mapWidth && nextY >= 0 && nextY < mapHeight) {
            System.out.println("Player move to [" + (nextX + 1) + ":" + (nextY + 1) + "] success!!!");
            return true;
        } else {
            playerPositionX = currentX;
            playerPositionY = currentY;
            System.out.println("Invalid move! Please try again!");
            return false;
        }
    }

    public static void createEnemies() {
        enemyAttackPoint = randomRange(enemyValueMin, enemyValueMax);
        enemyHealth = randomRange(enemyValueMin, enemyValueMax);

        int enemyCount = (mapWidth + mapHeight) / 4; // random logic count

        int enemyPosX;
        int enemyPosY;

        for (int i = 0; i < enemyCount; i++) {

            do {
                enemyPosX = random.nextInt(mapWidth);
                enemyPosY = random.nextInt(mapHeight);
            } while (enemyPosX == playerPositionX && enemyPosY == playerPositionY);
            invisibleMap[enemyPosY][enemyPosX] = enemy;
        }

        System.out.println("Enemy count: " + enemyCount + " (Enemy power = " + enemyAttackPoint + ", Enemy Health = " + enemyHealth + ")");
    }

    public static void createPlayer() {
        playerPositionX = randomRange(0, mapWidth - 1);
        playerPositionY = randomRange(0, mapHeight - 1);
        map[playerPositionY][playerPositionX] = player;
    }

    public static void createMap() {
        mapWidth = randomRange(mapSizeMin, mapSizeMax);
        mapHeight = randomRange(mapSizeMin, mapSizeMax);
        map = new char[mapHeight][mapWidth];
        invisibleMap = new char[mapHeight][mapWidth];

        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                map[y][x] = emptyCell;
            }
        }

        System.out.println("Create map. Size " + mapWidth + "x" + mapHeight);

    }

    public static void showMap() {
        System.out.println("===== MAP =====");
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                System.out.print(map[y][x] + "|");
            }
            System.out.println();
        }
        System.out.println("===============");
    }

    public static boolean isFullMap() {
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                if (map[y][x] == emptyCell) return false;
            }
        }
        return true;
    }

    public static boolean isPlayerAlive() {
        return playerHealth > 0;
    }


    public static int randomRange(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

}
