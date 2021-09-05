package AppWind;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;

public class Window extends JFrame {
    private int winWidth = 1600;
    private int winHeight = 900;
    private int winPosX = 150;
    private int winPosY = 150;

    private JPanel gui;
    private Map map;

    private JPanel appControlsPanel;
    private JButton btnStartGame;
    private JButton btnExitGame;

    private JPanel gameInfoPanel;
    private JLabel currentLevel;
    private JLabel currentMapSize;
    private JLabel countEnemies;

    Window() {
        setupWindow();

        map = new Map();

        setupGui();

        add(gui, BorderLayout.WEST);
        add(map);

        setVisible(true);
    }

    private void setupGui() {
        gui = new JPanel();
        gui.setLayout(new GridLayout(5, 1));

        setupAppControls();
        setupGameInfo();

        gui.add(appControlsPanel);
        gui.add(gameInfoPanel);
    }

    private void setupAppControls () {
        appControlsPanel = new JPanel();
        appControlsPanel.setLayout(new GridLayout(3, 1));

        btnStartGame = new JButton("Start Game");
        btnExitGame = new JButton("Exit Game");

        appControlsPanel.add(new JLabel("--== Game Menu ==--"));
        appControlsPanel.add(btnStartGame);
        appControlsPanel.add(btnExitGame);
    }

    private void setupGameInfo() {
        gameInfoPanel = new JPanel();
        gameInfoPanel.setLayout(new GridLayout(4, 1));

        currentLevel = new JLabel("Level Now: -");
        currentMapSize = new JLabel("Map Size: -");
        countEnemies = new JLabel("Enemies: -");

        gameInfoPanel.add(new JLabel("--== Game Info ==--"));
        gameInfoPanel.add(currentLevel);
        gameInfoPanel.add(currentMapSize);
        gameInfoPanel.add(countEnemies);
    }

    private void setupWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(winPosX, winPosY);
        setSize(winWidth, winHeight);
        setResizable(false);
        setTitle("It's Game");
    }
}
