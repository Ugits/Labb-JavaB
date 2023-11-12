package com.jonas.tales_of_descent_the_lost_senior.characters.monsters;

import com.jonas.tales_of_descent_the_lost_senior.characters.Hero;
import com.jonas.tales_of_descent_the_lost_senior.characters.Monster;

public class Goblin extends Monster {

    public Goblin(int floorNum) {
        super(
                "Goblin",
                floorNum,
                10,
                5,
                8,
                2,
                5,
                false);
    }

    @Override
    public void attack(Hero hero) {
        System.out.println("The goblin swings his dagger");
        // damage player
    }

    @Override
    public void attack(Monster monster) {

    }

    @Override
    public void advancedAttack() {
        System.out.println("*brrrrrrtt*... the goblin releases air!");
        //damage player
    }

    @Override
    public void flee() {
        System.out.println("The goblin starts crying and runs of!");

    }

    @Override
    public void parry() {

    }

    @Override
    public void dies() {
        getOut().printNarrative("GOBLIN DIES");
        setDead(true);
    }

}
