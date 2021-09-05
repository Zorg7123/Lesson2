package App;

import com.sun.deploy.panel.JavaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 01.09.2021
 */

public class GameWindow extends JFrame {

    private int winWidth = 1024;
    private int winHeight = 768;
    private int winPosX = 200;
    private int winPosY = 150;

    private JPanel gui;
    private GameMap map;

    private JPanel appControlsPanel;
    private JButton btnStartGame;
    private JButton btnExitGame;

    private JPanel gameInfoPanel;
    private JLabel currentLevel;
    private JLabel currentMapSize;
    private JLabel countEnemies;

    private JPanel playerInfoPanel;
    private JLabel playerHealth;
    private JLabel playerAttackPoint;
    private JLabel playerCoordinates;

    private JPanel playerMoveActionPanel;
    private JButton playerMoveUp;
    private JButton playerMoveDown;
    private JButton playerMoveLeft;
    private JButton playerMoveRight;

    private JTextArea gameLog;
    private JScrollPane scrollPanel;

    GameWindow() {
        setupWindow();

        map = new GameMap(this);

        setupGui();

        add(gui, BorderLayout.EAST);
        add(map);


        setVisible(true);
    }

    private void setupGui() { // внутри панели GUI
        gui = new JPanel();
        gui.setLayout(new GridLayout(5, 1));

        setupAppControls();
        setupGameInfo();
        setupPlayerInfo();
        setupPlayerMoveAction();
        setupLogArea();

        gui.add(appControlsPanel);
        gui.add(gameInfoPanel);
        gui.add(playerInfoPanel);
        gui.add(playerMoveActionPanel);
        gui.add(scrollPanel, BorderLayout.SOUTH);
    }

    private void setupAppControls() {
        appControlsPanel = new JPanel();
        appControlsPanel.setLayout(new GridLayout(3, 1));

        btnStartGame = new JButton("Start game");
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recordLog("Game Start");
                map.initMap();
            }
        });

        btnExitGame = new JButton("Exit game");
        btnExitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        appControlsPanel.add(new JLabel("=== Game menu ==="));
        appControlsPanel.add(btnStartGame);
        appControlsPanel.add(btnExitGame);
    }

    private void setupGameInfo() {
        gameInfoPanel = new JPanel();
        gameInfoPanel.setLayout(new GridLayout(4, 1));

        currentLevel = new JLabel("Current Level: - ");
        currentMapSize = new JLabel("Current map size: - ");
        countEnemies = new JLabel("Count Enemies: - ");

        gameInfoPanel.add(new JLabel("=== Game Info ==="));
        gameInfoPanel.add(currentLevel);
        gameInfoPanel.add(currentMapSize);
        gameInfoPanel.add(countEnemies);
    }

    private void setupPlayerInfo() {
        playerInfoPanel = new JPanel();
        playerInfoPanel.setLayout(new GridLayout(4, 1));

        playerHealth = new JLabel("Player HP: - ");
        playerAttackPoint = new JLabel("Player Attack: - ");
        playerCoordinates = new JLabel("Player Place: x:y ");

        playerInfoPanel.add(new JLabel("=== Player Info ==="));
        playerInfoPanel.add(playerHealth);
        playerInfoPanel.add(playerAttackPoint);
        playerInfoPanel.add(playerCoordinates);
    }

    private void setupPlayerMoveAction() {
        playerMoveActionPanel = new JPanel();
        playerMoveActionPanel.setLayout(new GridLayout(2, 3));

        playerMoveUp = new JButton("\uD83E\uDC45");
        playerMoveUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                map.update(GameMap.DIRECTION_UP);
            }
        });

        playerMoveDown = new JButton("\uD83E\uDC47");
        playerMoveDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                map.update(GameMap.DIRECTION_DOWN);
            }
        });

        playerMoveLeft = new JButton("\uD83E\uDC44");
        playerMoveLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                map.update(GameMap.DIRECTION_LEFT);
            }
        });

        playerMoveRight = new JButton("\uD83E\uDC46");
        playerMoveRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                map.update(GameMap.DIRECTION_RIGHT);
            }
        });

        playerMoveActionPanel.add(new JPanel());
        playerMoveActionPanel.add(playerMoveUp);
        playerMoveActionPanel.add(new JPanel());
        playerMoveActionPanel.add(playerMoveLeft);
        playerMoveActionPanel.add(playerMoveDown);
        playerMoveActionPanel.add(playerMoveRight);
    }

    private void setupLogArea() {
        gameLog = new JTextArea();
        scrollPanel = new JScrollPane(gameLog);
        gameLog.setEditable(false);
        gameLog.setLineWrap(true);
    }

    void recordLog(String msg) {
        gameLog.append(msg + "\n");
    }

    void refreshData() {
        currentLevel.setText("Current Level: " + map.getCurrentLevelInfo());
        currentMapSize.setText("Current map size: " + map.getMapSizeInfo());
        countEnemies.setText("Count Enemies: " + map.getCountEnemiesInfo());
        playerHealth.setText("Player HP: " + map.getPlayer().getHealth());
        playerAttackPoint.setText("Player Attack: " + map.getPlayer().getAttackPoint());
        playerCoordinates.setText("Player Place: " + map.getPlayer().getMyCoordinates());
    }

    private void setupWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(winPosX, winPosY);
        setSize(winWidth, winHeight);
        setResizable(false);
        setTitle("This is GAME");
    }

}
