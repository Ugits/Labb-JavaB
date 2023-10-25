package com.jonas.tales_of_descent_the_lost_senior.enviorment;

import com.jonas.tales_of_descent_the_lost_senior.characters.monsters.Goblin;
import com.jonas.tales_of_descent_the_lost_senior.characters.monsters.Monster;
import com.jonas.tales_of_descent_the_lost_senior.characters.monsters.PackOfRats;
import java.util.Random;

public class Room  {

    public boolean hasMonster;
    public Monster monster;
    public boolean hasStore;
    public boolean hasTreasure;
    public int visibility;
    String description; // generate random description

    public Room() {
        Random rand = new Random();
        //roll for has monster

        //roll what monster
        this.monster = fetchMonster(rand);

    }


    public Monster fetchMonster(Random rand) {
        int num = rand.nextInt(2)+1;
        Monster temp = null;
        switch (num) {
            case 1 -> {temp = new PackOfRats();}
            case 2 -> {temp = new Goblin();}
            case 3 -> {System.out.println("next monster");}
            default -> {System.out.println("no monster");}
        }
        return temp;
    }

}
