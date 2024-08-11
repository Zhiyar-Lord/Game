package com.ghoulstrike.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

import com.ghoulstrike.entity.Player;
import com.ghoulstrike.gui.gamethread.GameThread;
import com.ghoulstrike.gui.listeners.KeyHandler;

public class GamePanel extends JPanel {
    // screen settings
    private final int OGtileSize = 16; // 16x16 tiles
    private final int tileScale = 3; // scale to 48x48

    public final int tileSize = OGtileSize * tileScale;
    private final int maxScreenCol = 16;
    private final int maxScreenRow = 014;
    private final int screenWidth = tileSize * maxScreenCol; // 768 px
    private final int screenHeight = tileSize * maxScreenRow; // 567 px

    private KeyHandler keyH = new KeyHandler();
    Player player = new Player(this, keyH);

    // player default pos
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        init();
    }

    public int getTileSize() {
        return tileSize;
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
        player.update();
    }

    // paint player
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        player.draw(g2); // Draw the player with its image

        g2.dispose(); // Save resources
    }

}
