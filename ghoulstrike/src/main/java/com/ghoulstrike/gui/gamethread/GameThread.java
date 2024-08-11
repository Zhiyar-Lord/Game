package com.ghoulstrike.gui.gamethread;

import com.ghoulstrike.gui.GamePanel;

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
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {
            // restriction 60fps
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                gamePanel.update();
                gamePanel.repaint();
                delta--;
                drawCount++;
            }

            // draw FPS
            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }

        }
    }
}
