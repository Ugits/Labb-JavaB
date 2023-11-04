package com.jonas.tales_of_descent_the_lost_senior.characters.heroes;

import static com.jonas.tales_of_descent_the_lost_senior.resources.IColors.*;

public class Knight extends Hero{


    public Knight(String name) {
        super(
                name,
                5,
                5,
                5,
                50,
                0,
                1,
                1,
                false);
    }

    @Override
    public void attack() {

    }

    @Override
    public void advancedAttack() {

    }

    @Override
    public void flee() {

    }

    @Override
    public void parry() {

    }

    @Override
    public String getLevelToStatus() {
        return RED_BOLD + "         <Lvl " + getLevel() + ">" + RESET;
    }
}
