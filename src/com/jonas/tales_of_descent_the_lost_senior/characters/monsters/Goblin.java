package com.jonas.tales_of_descent_the_lost_senior.characters.monsters;

public class Goblin extends Monster {

    public Goblin() {
        super("Goblin", 7, 2, false);
    }

    @Override
    public void attack() {
        System.out.println("The goblin swings his dagger");
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
}
