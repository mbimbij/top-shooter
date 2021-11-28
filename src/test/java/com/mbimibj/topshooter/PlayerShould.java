package com.mbimibj.topshooter;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.mbimibj.topshooter.Bullet.BULLET_SPEED;
import static com.mbimibj.topshooter.TestUtils.degreeToRadiant;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class PlayerShould {
    @ParameterizedTest
    @CsvSource({
            "0, 0, 1, 0, 0, 0, 0",
            "0, 0, 1, 0, 1, 1, 0",
            "0, 0, 1, 45, 1, 0.7071, 0.7071",
            "0, 0, 1, 90, 1, 0, 1",
            "0, 0, 1, 135, 1, -0.7071, 0.7071",
            "0, 0, 1, 180, 1, -1, 0",
            "0, 0, 1, 225, 1, -0.7071, -0.7071",
            "0, 0, 1, 270, 1, 0, -1",
            "0, 0, 1, 315, 1, 0.7071, -0.7071",
            "0, 0, 1, 315, 0.5, 0.3535, -0.3535",
    })
    void moveAccordingToLeftStick(double initX, double initY, double speed, double joyAngleDegree, double joyStrength, double expectedX, double expectedY) {
        // GIVEN
        Player player = new Player(initX, initY, speed, 0);
        double joystickAngleRadiant = degreeToRadiant(joyAngleDegree);

        // WHEN
        Player updatedPlayer = player.move(joystickAngleRadiant, joyStrength);

        // THEN
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(updatedPlayer.getX()).isEqualTo(expectedX, Offset.offset(0.0001));
            softAssertions.assertThat(updatedPlayer.getY()).isEqualTo(expectedY, Offset.offset(0.0001));
        });
    }

    @Test
    void shootBullet() {
        // GIVEN
        double playerX = 1;
        double playerY = 2;
        double speed = 3;
        int playerOrientation = 4;
        Player player = new Player(playerX, playerY, speed, playerOrientation);

        // WHEN
        Bullet bullet = player.shoot();

        // THEN
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(bullet.getX()).isEqualTo(playerX);
            softAssertions.assertThat(bullet.getY()).isEqualTo(playerY);
            softAssertions.assertThat(bullet.getSpeed()).isEqualTo(BULLET_SPEED);
            softAssertions.assertThat(bullet.getOrientation()).isEqualTo(playerOrientation);
        });
    }

    @Test
    void name() {
        System.out.println(Math.sqrt(2)/4);
    }
}
