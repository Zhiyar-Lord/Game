package com.farmgame.GUI;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
    public GameWindow() {
        this.init();
    }

    public void init() {
        this.setResizable(false);
        this.setTitle("Farming Game");

        GamePanel gamePanel = new GamePanel();
        this.add(gamePanel);

        this.pack();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
