package com.jonas.tales_of_descent_the_lost_senior.characters.heroes;

import com.jonas.tales_of_descent_the_lost_senior.interaction.DiceSet;

public class Ranger extends Hero{

    public Ranger(String name) {
        super(
                name,
                1,
                100,
                5,
                8,
                5,
                12,
                false);
    }

    @Override
    public void attack() {
        getOut().println(getName() + " fires an arrow!");
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
        return GREEN_BOLD +" [" + getLevel() + "]"+RESET;
    }

    @Override
    public int getMainAttribute() {
        return getDexterity();
    }


}
