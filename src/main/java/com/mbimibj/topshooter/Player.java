package com.mbimibj.topshooter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    double x;
    double y;
    double speed;
    double orientation;

    public void move(double joystickAngle, double joystickStrength) {
        double deltaX = Math.cos(joystickAngle) * joystickStrength * speed;
        double deltaY = Math.sin(joystickAngle) * joystickStrength * speed;
        x += deltaX;
        y += deltaY;
    }

    public Player setOrientation(double orientation) {
        return new Player(x, y, speed, orientation);
    }

    public Bullet shoot() {
        return new Bullet(x, y, orientation);
    }
}
