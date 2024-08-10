package com.farmgame.GUI.GameThread;

import com.farmgame.GUI.GamePanel;

public class GameThread implements Runnable {
    private Thread gameThread;
    private GamePanel gamePanel;
    private int fps = 60;

    public GameThread(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        gameThread = new Thread(this);
    }

    public void start() {
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / fps; // 1 million nano sec = 1 sec -- 0.017 seconds
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {
            // restriction 60fps
            gamePanel.update();
            gamePanel.repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;

                // if the allocated time goes below 0 then dont need sleep
                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (Exception e) {
                System.out.println("draw interval error");
            }
        }
    }
}
