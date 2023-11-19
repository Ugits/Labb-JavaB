package com.jonas.tales_of_descent_the_lost_senior.characters.hero.models;

import com.jonas.tales_of_descent_the_lost_senior.Game;
import com.jonas.tales_of_descent_the_lost_senior.characters.Character;
import com.jonas.tales_of_descent_the_lost_senior.characters.hero.Hero;

public class Mage extends Hero {

    public Mage() {
        super(
                BLUE_BOLD + "The Mage" + RESET,
                1,
                50,
                5,
                5,
                8,
                5,
                false);
    }

    @Override
    public void attack(Character monster, Game game) {
        getOut().println(getName() + " casts a fireball!");
        attackLogics(this,this, monster,game);
        setAttacking(false);
    }


    @Override
    public String getLevelToStatus() {
        return BLUE_BOLD +" [" + getLevel() + "]"+RESET;
    }

    @Override
    public int getMainAttribute() {
        return getIntelligence();
    }

    public void setMainAttribute(int newValue) {
        setIntelligence(newValue);
    }
}
