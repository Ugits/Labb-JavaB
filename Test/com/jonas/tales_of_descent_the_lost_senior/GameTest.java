package com.jonas.tales_of_descent_the_lost_senior;

import com.jonas.tales_of_descent_the_lost_senior.characters.Character;
import com.jonas.tales_of_descent_the_lost_senior.characters.hero.models.Ranger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game;
    Character ranger;
    @BeforeEach
    public void setUp() {
        game = new Game();
        ranger = new Ranger();
    }


    @Test
    void run() {
        game.setGameOver(false);
        ranger.setDead(true);
        ranger.setRevives(0);

        if (ranger.isDead() && ranger.getRevives() <= 0) {

            game.setGameOver(true);

        }

        assertTrue(game.isGameOver());
        assertFalse(!game.isGameOver());
    }
}