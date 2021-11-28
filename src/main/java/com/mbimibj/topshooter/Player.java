package com.mbimibj.topshooter;

import lombok.Value;

@Value
public class Player {
    double x;
    double y;
    double speed;
    double orientation;

    public Player move(double joystickAngle, double joystickStrength) {
        double deltaX = Math.cos(joystickAngle) * joystickStrength * speed;
        double deltaY = Math.sin(joystickAngle) * joystickStrength * speed;
        return new Player(x + deltaX, y + deltaY, speed, orientation);
    }

    public Player setOrientation(double orientation) {
        return new Player(x, y, speed, orientation);
    }
}
