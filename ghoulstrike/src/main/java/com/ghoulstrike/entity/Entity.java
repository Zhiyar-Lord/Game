package com.ghoulstrike.entity;

import java.awt.image.BufferedImage;

public class Entity {
    protected int x, y;
    protected int speed;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    protected BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;

    protected String direction;
}
