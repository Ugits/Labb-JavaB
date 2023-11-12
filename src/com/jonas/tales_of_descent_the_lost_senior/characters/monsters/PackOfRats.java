package com.jonas.tales_of_descent_the_lost_senior.characters.monsters;

import com.jonas.tales_of_descent_the_lost_senior.characters.Hero;
import com.jonas.tales_of_descent_the_lost_senior.characters.Monster;
import com.jonas.tales_of_descent_the_lost_senior.player.Player;


public class PackOfRats extends Monster {

    public PackOfRats(int floorNum) {
        super(
                "Pack of Rats",
                floorNum,
                10,
                5,
                2,
                3,
                8,
                false);
    }

    @Override
    public void attack(Hero hero) {
        System.out.println("A rat jumps your leg, and bites!");
        attackLogics(this, hero);
        //damage player
    }

    @Override
    public void attack(Monster monster) {

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
    public void dies() {
        getOut().printNarrative("squeeeck.. you flatten the last rat under you boot");
        setDead(true);
    }


}
