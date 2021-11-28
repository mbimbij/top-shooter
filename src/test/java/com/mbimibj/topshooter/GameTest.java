package com.mbimibj.topshooter;

import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    void canCreateGame() {
        Game game = new Game();
        Player player = new Player(0d,0d);
    }
}
