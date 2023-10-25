package com.jonas.tales_of_descent_the_lost_senior.enviorment;

import com.jonas.tales_of_descent_the_lost_senior.characters.monsters.Monster;
import com.jonas.tales_of_descent_the_lost_senior.characters.monsters.PackOfRats;
import com.sun.source.tree.YieldTree;

import java.util.Random;

public class Room  {

    public boolean hasMonster;
    public Monster monster;
    public boolean hasStore;
    public boolean hasTreasure;
    public int visibility;
    String description; // generate random description

    public Room() {
        //roll for has monster
        this.monster = fetchMonster();

    }


    public Monster fetchMonster() {
        Random rand = new Random();
        int num = 1;   //rand.nextInt();
        Monster temp = null;
        switch (num) {
            case 1 -> {temp = new PackOfRats();}
            case 2 -> {System.out.println("next monster");}
            default -> {System.out.println("no monster");}
        }
        return temp;
    }

}
