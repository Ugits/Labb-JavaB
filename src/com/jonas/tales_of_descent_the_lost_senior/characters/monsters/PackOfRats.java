package com.jonas.tales_of_descent_the_lost_senior.characters.monsters;

import static com.jonas.tales_of_descent_the_lost_senior.resources.IColors.*;


public class PackOfRats extends Monster {

    public PackOfRats(int floorNum) {
        super(
                "Pack of Rats",
                3,
                1,
                false,
                floorNum);
    }

    @Override
    public void attack() {
        System.out.println("A rat jumps your leg, and bites!");
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

}
