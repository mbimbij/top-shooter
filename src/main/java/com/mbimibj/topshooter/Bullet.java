package com.mbimibj.topshooter;

import lombok.Data;

@Data
public class Bullet {
    public static final double BULLET_SPEED = 2;
    private double x;
    double y;
    double speed = BULLET_SPEED;
    double orientation;

    public Bullet(double x, double y, double orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public void move() {
        x += Math.cos(orientation) * speed;
        y += Math.sin(orientation) * speed;
    }
}
