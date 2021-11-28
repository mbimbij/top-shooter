package com.mbimibj.topshooter;

import org.assertj.core.data.Offset;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class PlayerShould {

    @ParameterizedTest
    @CsvSource({
            "0, 0, 1, 0, 0, 0, 0",
            "0, 0, 1, 0, 1, 1, 0"
    })
    void doNotMoveWhenNoInput(double initX, double initY, double speed, double joyAngle, double joyStrength, double expectedX, double expectedY) {
        // GIVEN
        Player player = new Player(initX, initY, speed);
        double joystickAngle = joyAngle;
        double joystickStrength = joyStrength;

        // WHEN
        Player updatedPlayer = player.move(joystickAngle, joystickStrength);

        // THEN
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(updatedPlayer.getX()).isEqualTo(expectedX, Offset.offset(0.0001));
            softAssertions.assertThat(updatedPlayer.getY()).isEqualTo(expectedY, Offset.offset(0.0001));
        });
    }
}
