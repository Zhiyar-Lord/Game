package com.farmgame.GUI;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
    public GameWindow() {
        this.init();
    }

    public void init() {
        this.setResizable(false);
        this.setTitle("Farming Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
}
