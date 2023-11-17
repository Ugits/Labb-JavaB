package com.jonas.tales_of_descent_the_lost_senior.characters.hero.models;

import com.jonas.tales_of_descent_the_lost_senior.characters.Character;
import com.jonas.tales_of_descent_the_lost_senior.characters.hero.Hero;

public class Ranger extends Hero {

    public Ranger() {
        super(
                GREEN_BOLD + "The Ranger" + RESET,
                1,
                100,
                5,
                5,
                5,
                8,
                false);
    }

    @Override
    public void attack(Character monster) {

        getOut().print(getName() + " fires an arrow!");
        consumeStamina(ATTACK);

        attackLogics(this,this, monster);
        setAttacking(false);

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
