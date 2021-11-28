package com.mbimibj.topshooter;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    void movesPlayerForInput(double initX, double initY, double speed, double joyAngleDegree, double joyStrength, double expectedX, double expectedY) {
        // GIVEN
        Player player = new Player(initX, initY, speed);
        double joystickAngleRadiant = degreeToRadiant(joyAngleDegree);
        double joystickStrength = joyStrength;

        // WHEN
        Player updatedPlayer = player.move(joystickAngleRadiant, joystickStrength);

        // THEN
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(updatedPlayer.getX()).isEqualTo(expectedX, Offset.offset(0.0001));
            softAssertions.assertThat(updatedPlayer.getY()).isEqualTo(expectedY, Offset.offset(0.0001));
        });
    }


    @Test
    void name() {
        System.out.println(Math.sqrt(2)/4);
    }

    private double degreeToRadiant(double angleDegree) {
        return angleDegree * Math.PI / 180d;
    }
}
