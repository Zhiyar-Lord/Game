package com.farmgame.GUI;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

import com.farmgame.GUI.GameThread.GameThread;
import com.farmgame.GUI.Listeners.KeyHandler;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel {
    // screen settings
    private final int OGtileSize = 16; // 16x16 tiles
    private final int tileScale = 3; // scale to 48x48

    private final int tileSize = OGtileSize * tileScale;
    private final int maxScreenCol = 16;
    private final int maxScreenRow = 12;
    private final int screenWidth = tileSize * maxScreenCol; // 768 px
    private final int screenHeight = tileSize * maxScreenRow; // 567 px

    private KeyHandler keyH = new KeyHandler();

    // player default pos
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        init();
    }

    public void init() {
        this.setPreferredSize(new DimensionUIResource(screenWidth, screenHeight));

        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // improved rendering perf
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        new GameThread(this);
    }

    // change player position
    public void update() {

    }

    // paint player
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose(); // save
    }

}
