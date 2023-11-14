package com.jonas.tales_of_descent_the_lost_senior.characters.monster.models;

import com.jonas.tales_of_descent_the_lost_senior.characters.Character;
import com.jonas.tales_of_descent_the_lost_senior.characters.monster.Monster;

public class NoMonster extends Monster {

    public NoMonster() {
        super(
                "No monster",
                0,
                0,
                0,
                0,
                0,
                0,
                true);
    }


    @Override
    public void attack(Character monster) {

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
}
