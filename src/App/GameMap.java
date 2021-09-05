package App;

import App.models.Enemy;
import App.models.Player;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 01.09.2021
 */

public class GameMap extends JPanel {

    private GameWindow gameWindow;

    public static final int DIRECTION_UP = 8;
    public static final int DIRECTION_LEFT = 4;
    public static final int DIRECTION_RIGHT = 6;
    public static final int DIRECTION_DOWN = 2;

    private final int LABEL_PLAYER = 1;
    private final int LABEL_ENEMY = 2;
    private final int LABEL_READY = 90;
    private final int LABEL_EMPTY = 0;

    private Player player;
    private Enemy enemy;

    private int[][] map;
    private int[][] invisibleMap;
    private int mapWidth;
    private int mapHeight;
    private int mapSizeMin = 3;
    private int mapSizeMax = 6;

    private int currentLevel;
    private int countEnemies;

    private int cellWidth;
    private int cellHeight;

    private boolean isMapExist;
    private boolean isGameOver;

    GameMap(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.BLACK);
        isMapExist = false;
        isGameOver = false;
    }

    void initMap() {
        player = new Player();
        currentLevel = 0;
        startNewRound();
        isMapExist = true;
        isGameOver = false;
    }

    private void startNewRound() {
        createMap();
        initPlayer();
        createEnemies();
        ++currentLevel;
        gameWindow.recordLog("== Start round " + currentLevel + " ==");
        gameWindow.refreshData();
    }

    private void render(Graphics g) {
        drawMap(g);

        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {

                if (map[y][x] == LABEL_EMPTY) {
                    continue;
                }

                if (map[y][x] == LABEL_PLAYER) {
                    g.setColor(Color.GREEN);
                    g.fillRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                }

                if (map[y][x] == LABEL_READY) {
                    g.setColor(Color.GRAY);
                    g.fillRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                }
            }
        }
    }

    private void drawMap(Graphics g) {
        if (!isMapExist) {
            return;
        }

        int widthSelf = getWidth();
        int heightSelf = getHeight();

        cellWidth = widthSelf / mapWidth;
        cellHeight = heightSelf / mapHeight;

        g.setColor(Color.WHITE);

        for (int i = 0; i <= mapHeight; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, widthSelf, y);
        }

        for (int i = 0; i <= mapWidth; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, heightSelf);
        }
    }

    void update(int direction) {
        if (isGameOver) {
            return;
        }

        if (!isMapExist) {
            return;
        }

        int currentX = player.getX();
        int currentY = player.getY();

        switch (direction) {
            case DIRECTION_UP:
                player.moveUp();
                break;
            case DIRECTION_LEFT:
                player.moveLeft();
                break;
            case DIRECTION_DOWN:
                player.moveDown();
                break;
            case DIRECTION_RIGHT:
                player.moveRight();
                break;
        }

        if (!isValidPlayerStep(currentX, currentY, player.getX(), player.getY())) {
            return;
        }

        playerNextMoveAction(currentX, currentY, player.getX(), player.getY());
        gameWindow.refreshData();
        repaint();

        if (isFullMap()) {
            startNewRound();
        }

        if (!player.isAlive()) {
            isGameOver = true;
            gameWindow.recordLog("Player dead");
            JOptionPane.showMessageDialog(this, "Game over! Player is dead");
        }
    }

    private void playerNextMoveAction(int currentX, int currentY, int nextX, int nextY) {
        if (invisibleMap[nextY][nextX] == LABEL_ENEMY) {
//            player.decreaseHealth(enemy.getAttackPoint());
            battle();
        }

        map[currentY][currentX] = LABEL_READY;
        map[nextY][nextX] = LABEL_PLAYER;
        invisibleMap[nextY][nextX] = LABEL_EMPTY;
    }

    private void battle() {
        int battleRoundCount = 1;
        int currentEnemyHealth = enemy.getHealth();

        while (player.getHealth() > 0 && currentEnemyHealth > 0) {
            currentEnemyHealth -= player.getAttackPoint();
            player.decreaseHealth(enemy.getAttackPoint());
            battleRoundCount++;
        }

        if (currentEnemyHealth <= 0) {
            countEnemies--;
        }
    }

    private boolean isValidPlayerStep(int currentX, int currentY, int nextX, int nextY) {
        if (nextX >= 0 && nextX < mapWidth && nextY >= 0 && nextY < mapHeight) {
            gameWindow.recordLog("Player move to [" + (nextX + 1) + ":" + (nextY + 1) + "] success!!!");
            return true;
        } else {
            player.setPosition(currentX, currentY);
            gameWindow.recordLog("Invalid move! Please try again!");
            return false;
        }
    }

    private void createEnemies() {
        int enemyPosX;
        int enemyPosY;

        countEnemies = (mapWidth + mapHeight) / 4; // random logic count

        for (int i = 0; i < countEnemies; i++) {
            do {
                enemyPosX = Tools.random.nextInt(mapWidth);
                enemyPosY = Tools.random.nextInt(mapHeight);
            } while (enemyPosX == player.getX() && enemyPosY == player.getY());
            invisibleMap[enemyPosY][enemyPosX] = LABEL_ENEMY;
        }
        enemy = new Enemy();
    }

    public void initPlayer() {
        player.setPosition(Tools.randomRange(0, mapWidth - 1), Tools.randomRange(0, mapHeight - 1));
        map[player.getY()][player.getX()] = LABEL_PLAYER;
    }

    public void createMap() {
        mapWidth = Tools.randomRange(mapSizeMin, mapSizeMax);
        mapHeight = Tools.randomRange(mapSizeMin, mapSizeMax);
        map = new int[mapHeight][mapWidth];
        invisibleMap = new int[mapHeight][mapWidth];
        repaint();
    }

    public boolean isFullMap() {
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                if (map[y][x] == LABEL_EMPTY) return false;
            }
        }
        return true;
    }

    public int getCurrentLevelInfo() {
        return currentLevel;
    }

    public int getCountEnemiesInfo() {
        return countEnemies;
    }

    public String getMapSizeInfo() {
        return mapWidth + "x" + mapHeight;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    public Player getPlayer() {
        return player;
    }
}
