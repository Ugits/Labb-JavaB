package com.jonas.tales_of_descent_the_lost_senior.characters.heroes;

import com.jonas.tales_of_descent_the_lost_senior.characters.Hero;
import com.jonas.tales_of_descent_the_lost_senior.characters.Monster;

public class Mage extends Hero {

    public Mage() {
        super(
                BLUE_BOLD + "The Mage" + RESET,
                1,
                100,
                5,
                5,
                12,
                8,
                false);
    }

    @Override
    public void attack(Monster monster) {
        getOut().println(getName() + " casts a fireball!");
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
        return BLUE_BOLD +" [" + getLevel() + "]"+RESET;
    }

    @Override
    public int getMainAttribute() {
        return getIntelligence();
    }
}
