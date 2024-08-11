package com.ghoulstrike.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.ghoulstrike.gui.GamePanel;
import com.ghoulstrike.gui.listeners.KeyHandler;

public class Player extends Entity {
    GamePanel gamePanel;
    KeyHandler keyH;

    public Player(GamePanel gamePanel, KeyHandler keyH) {
        this.gamePanel = gamePanel;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "left";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/assets/Entities/Blue Boy Adventure/Player/Walking sprites/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/assets/Entities/Blue Boy Adventure/Player/Walking sprites/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/assets/Entities/Blue Boy Adventure/Player/Walking sprites/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/assets/Entities/Blue Boy Adventure/Player/Walking sprites/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/assets/Entities/Blue Boy Adventure/Player/Walking sprites/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/assets/Entities/Blue Boy Adventure/Player/Walking sprites/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/assets/Entities/Blue Boy Adventure/Player/Walking sprites/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/assets/Entities/Blue Boy Adventure/Player/Walking sprites/boy_right_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public void update() {
        if (keyH.getUpPressed()) {
            direction = "up";
            y -= speed;
        } else if (keyH.getDownPressed()) {
            direction = "down";
            y += speed;
        } else if (keyH.getLeftPressed()) {
            direction = "left";
            x -= speed;
        } else if (keyH.getRightPressed()) {
            direction = "right";
            x += speed;
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (direction) {
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
        }

        g2.drawImage(image, x, y, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
    }
}
