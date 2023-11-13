package com.jonas.tales_of_descent_the_lost_senior.characters.heroes;

import com.jonas.tales_of_descent_the_lost_senior.characters.Character;
import com.jonas.tales_of_descent_the_lost_senior.characters.Hero;
import com.jonas.tales_of_descent_the_lost_senior.characters.Monster;

public class Ranger extends Hero {

    public Ranger() {
        super(
                GREEN_BOLD + "The Ranger" + RESET,
                1,
                100,
                5,
                8,
                5,
                12,
                false);
    }

    @Override
    public void attack(Character monster) {

        getOut().println(getName() + " fires an arrow!");

        System.out.println("consume 5 stamina");
        consumeStamina(5); // Interface stamina consumption. eg. HIT = 5

        attackLogics(this, monster);

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
