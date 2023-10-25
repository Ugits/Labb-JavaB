package com.jonas.tales_of_descent_the_lost_senior.interaction;

import java.util.Random;

public class DiceSet {
    public void d20(){
        Random roll = new Random();
        while (true){
        int result = roll.nextInt(20)+1;
            System.out.println(result);
        }
    }
}
