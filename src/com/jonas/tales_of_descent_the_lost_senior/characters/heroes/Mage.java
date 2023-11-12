package com.jonas.tales_of_descent_the_lost_senior.characters.heroes;

public class Mage extends Hero{

    public Mage(String name) {
        super(
                name,
                1,
                100,
                5,
                5,
                12,
                8,
                false);
    }

    @Override
    public void attack() {
        getOut().println(getName() + " casts a fireball!");
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
