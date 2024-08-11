package com.ghoulstrike.gui;

import javax.swing.JFrame;

import com.ghoulstrike.gui.gamethread.GameThread;

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

        GameThread gameThread = new GameThread(gamePanel);
        gameThread.start();
    }
}
