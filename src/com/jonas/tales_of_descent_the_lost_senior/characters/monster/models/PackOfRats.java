package com.jonas.tales_of_descent_the_lost_senior.characters.monster.models;

import com.jonas.tales_of_descent_the_lost_senior.Game;
import com.jonas.tales_of_descent_the_lost_senior.characters.Character;
import com.jonas.tales_of_descent_the_lost_senior.characters.monster.Monster;

public class PackOfRats extends Monster {

    public PackOfRats(int floorNum) {
        super(
                "Pack of Rats",
                floorNum,
                8,
                3,
                2,
                3,
                8,
                false);
    }

    @Override
    public void attack(Character hero, Game game) {
        getOut().println(RED_BOLD + "A Rat" + RESET + " jumps your leg, and bites!");
        attackLogics(hero,this, hero,game);
        hero.setAttacking(true);
        //damage player
    }

    @Override
    public void advancedAttack() {
        System.out.println("The pack surrounds you, biting and scratching!");
        //damage player
    }

    @Override
    public void flee() {
        System.out.println("They run away. The rats seams frightened by something,");
    }

    @Override
    public void parry() {

    }

    @Override
    public void dies(Game game) {
        getOut().printNarrative("squeeeck.. you flatten the last rat under you boot");
        setDead(true);
    }


}
