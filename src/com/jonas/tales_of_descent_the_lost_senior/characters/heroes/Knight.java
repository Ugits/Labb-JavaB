package com.jonas.tales_of_descent_the_lost_senior.characters.heroes;

import com.jonas.tales_of_descent_the_lost_senior.characters.Hero;
import com.jonas.tales_of_descent_the_lost_senior.characters.Monster;

public class Knight extends Hero {

    public Knight() {
        super(
                RED_BOLD + "The Knight" + RESET,
                1,
                100,
                5,
                12,
                5,
                8,
                false);
    }

    @Override
    public void attack(Monster monster) {
        getOut().println(getName() + " swings his sword!");
        attackLogics(this, monster);
    }

    @Override
    public void attack(Hero player) {

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
