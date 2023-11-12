package com.jonas.tales_of_descent_the_lost_senior.characters.heroes;

public class Knight extends Hero {

    public Knight(String name) {
        super(
                name,
                1,
                100,
                5,
                12,
                5,
                8,
                false);
    }

    @Override
    public void attack() {
        getOut().println(getName() + " swings his sword!");
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
    public void dies() {

    }

    @Override
    public String getLevelToStatus() {
        return RED_BOLD + " [" + getLevel() + "]" + RESET;
    }

    @Override
    public int getMainAttribute() {
        return getStrength();
    }
}
