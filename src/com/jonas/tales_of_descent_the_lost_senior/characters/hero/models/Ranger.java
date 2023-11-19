package com.jonas.tales_of_descent_the_lost_senior.characters.hero.models;

import com.jonas.tales_of_descent_the_lost_senior.Game;
import com.jonas.tales_of_descent_the_lost_senior.characters.Character;
import com.jonas.tales_of_descent_the_lost_senior.characters.hero.Hero;
import com.jonas.tales_of_descent_the_lost_senior.interaction.DiceSet;

public class Ranger extends Hero {

    public Ranger() {
        super(
                GREEN_BOLD + "The Ranger" + RESET,
                1,
                50,
                5,
                5,
                5,
                8,
                false);
    }

    @Override
    public void attack(Character monster, Game game) {
        getOut().println(getName() + " fires an arrow!");
        attackLogics(this,this, monster, game);
        setAttacking(false);
    }


    @Override
    public String getLevelToStatus() {
        return GREEN_BOLD +" [" + getLevel() + "]"+RESET;
    }

    @Override
    public int getMainAttribute() {
        return getDexterity();
    }

    public void setMainAttribute(int newValue) {
        setDexterity(newValue);
    }


}
