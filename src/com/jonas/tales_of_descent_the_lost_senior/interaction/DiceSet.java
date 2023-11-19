package com.jonas.tales_of_descent_the_lost_senior.interaction;

import java.util.Random;

public class DiceSet {


    public int d20() {
        Random roll = new Random();
        return roll.nextInt(20) + 1;
    }

    public int d10() {
        Random roll = new Random();
        return roll.nextInt(10) + 1;
    }

    public int dCustom(int dSize) {
        Random roll = new Random();
        return roll.nextInt(dSize) + 1;
    }
}
