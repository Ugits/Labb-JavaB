package com.jonas.tales_of_descent_the_lost_senior.characters.hero.models;

import com.jonas.tales_of_descent_the_lost_senior.Game;
import com.jonas.tales_of_descent_the_lost_senior.characters.Character;
import com.jonas.tales_of_descent_the_lost_senior.characters.hero.Hero;

public class Knight extends Hero {

    public Knight() {
        super(
                RED_BOLD + "The Knight" + RESET,
                1,
                100,
                5,
                8,
                5,
                5,
                false);
    }

    @Override
    public void attack(Character monster, Game game) {
        getOut().println(getName() + " swings his sword!");
        attackLogics(this,this, monster,game);
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
        return RED_BOLD + " [" + getLevel() + "]" + RESET;
    }

    @Override
    public int getMainAttribute() {
        return getStrength();
    }

    public void setMainAttribute(int newValue) {
        setStrength(newValue);
    }
}
