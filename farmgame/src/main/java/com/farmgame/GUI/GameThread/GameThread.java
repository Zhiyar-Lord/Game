package com.farmgame.GUI.GameThread;

import com.farmgame.GUI.GamePanel;

public class GameThread implements Runnable {
    private Thread gameThread;
    private GamePanel gamePanel;

    public GameThread(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        gameThread = new Thread(this);
    }

    public void start() {
        gameThread.start();
    }

    @Override
    public void run() {
        while (gameThread != null) {
            System.out.println("Game loop is running");
        }
    }

}
