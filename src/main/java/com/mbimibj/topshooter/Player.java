package com.mbimibj.topshooter;

import lombok.Value;

@Value
public class Player {
    double x;
    double y;
    double speed;

    public Player move(double joystickAngle, double joystickStrength) {
        double deltaX = Math.cos(joystickAngle) * joystickStrength * speed;
        double deltaY = Math.sin(joystickAngle) * joystickStrength * speed;
        return new Player(x + deltaX, y + deltaY, speed);
    }
}
