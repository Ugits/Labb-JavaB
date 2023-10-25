package com.jonas.tales_of_descent_the_lost_senior.enviorment;

import com.jonas.tales_of_descent_the_lost_senior.characters.monsters.Goblin;
import com.jonas.tales_of_descent_the_lost_senior.characters.monsters.Monster;
import com.jonas.tales_of_descent_the_lost_senior.characters.monsters.PackOfRats;
import com.jonas.tales_of_descent_the_lost_senior.interaction.DiceSet;


public class Room {

    //public boolean hasMonster;
    public Monster monster;
    public boolean hasStore;
    public boolean hasTreasure;
    public int visibility;
    String description; // generate random description

    public Room() {
        DiceSet roll = new DiceSet();
        // roll for has monster, if true, assign monster
        this.monster = (roll.d20() > 8) ? fetchMonster(roll.dCustom(2)) : null;

        // has store todo implement store

        // has tressure todo modify with LUCK //
        this.hasTreasure = roll.d20() > 16;





    }


    //roll what monster
    public Monster fetchMonster(int roll) {

        Monster temp = null;
        switch (roll) {
            case 1 -> {temp = new PackOfRats();}
            case 2 -> {temp = new Goblin();}
            case 3 -> {System.out.println("next monster");}
            default -> {System.out.println("no monster");}
        }
        return temp;
    }


}
