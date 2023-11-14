package com.jonas.tales_of_descent_the_lost_senior.characters.monster.models;

import com.jonas.tales_of_descent_the_lost_senior.characters.Character;
import com.jonas.tales_of_descent_the_lost_senior.characters.monster.Monster;

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
    public void attack(Character hero) {
        System.out.println("The goblin swings his dagger");
        attackLogics(this,hero);
        // damage player
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
