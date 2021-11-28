package com.mbimibj.topshooter;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.mbimibj.topshooter.TestUtils.degreeToRadiant;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class BulletShould {
    @ParameterizedTest
    @CsvSource({
            "0, 0,   0,      2,      0",
            "0, 0,  45,  1.414,  1.414",
            "0, 0,  90,      0,      2",
            "0, 0, 135, -1.414,  1.414",
            "0, 0, 180,     -2,      0",
            "0, 0, 225, -1.414, -1.414",
            "0, 0, 270,      0,     -2",
            "0, 0, 315,  1.414, -1.414",
            "0, 0, 360,      2,      0",
    })
    void moveAccordingToItsPositionAndDirection(double initX, double initY, double orientationDegrees, double expectedX, double expectedY) {
        // GIVEN
        double orientationRadiant = degreeToRadiant(orientationDegrees);
        Bullet bullet = new Bullet(initX, initY, orientationRadiant);

        // WHEN
        bullet.move();

        // THEN
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(bullet.getX()).isEqualTo(expectedX, Offset.offset(0.001));
            softAssertions.assertThat(bullet.getY()).isEqualTo(expectedY, Offset.offset(0.001));
        });
    }

    @Test
    void name() {
        System.out.println(Math.cos(Math.PI/4) * Bullet.BULLET_SPEED);
    }
}