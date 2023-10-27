package com.jonas.tales_of_descent_the_lost_senior.enviorment.dungeon;

import com.jonas.tales_of_descent_the_lost_senior.characters.monsters.Goblin;
import com.jonas.tales_of_descent_the_lost_senior.characters.monsters.Monster;
import com.jonas.tales_of_descent_the_lost_senior.characters.monsters.NoMonster;
import com.jonas.tales_of_descent_the_lost_senior.characters.monsters.PackOfRats;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.Atmosphere;
import com.jonas.tales_of_descent_the_lost_senior.interaction.DiceSet;
import com.jonas.tales_of_descent_the_lost_senior.resources.CustomString;


public class Room extends Atmosphere {

    //public boolean hasMonster;
    public int difficulty;
    public int onFloor;
    public int num;
    public boolean hasMonster;
    public Monster monster;
    public boolean hasStore;
    public boolean hasTreasure;
    String description; // generate random description

    public Room(int floorNum, int roomNum) {
        super(-floorNum, -floorNum);
        this.difficulty = floorNum;
        this.onFloor = floorNum;
        this.num = roomNum;

        DiceSet roll = new DiceSet();
        // roll for has monster, if true, assign monster
        this.monster = (roll.d20() > 12) ? fetchMonster(roll.dCustom(2)) : null; // Abstract clas cant be null?

        // has store todo implement store

        // has tressure todo modify with LUCK //
        this.hasTreasure = roll.d20() > 16;

        // set description
        CustomString string = new CustomString();
        this.description = string.roomDescriptionExample;


    }


    //roll what monster
    public Monster fetchMonster(int roll) {
        this.hasMonster = true;
        Monster temp = null;
        switch (roll) {
            case 1 -> {
                temp = new PackOfRats();
            }
            case 2 -> {
                temp = new Goblin();
            }

            default -> {
                System.out.println("check random number in fetch Monster");
            }
        }

        return temp;
    }

    public boolean isHasMonster() {
        return hasMonster;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getOnFloor() {
        return onFloor;
    }

    public int getNum() {
        return num;
    }

    public Monster getMonster() {
        return monster;
    }

    public boolean isHasStore() {
        return hasStore;
    }

    public boolean isHasTreasure() {
        return hasTreasure;
    }

    public String getDescription() {
        return description;
    }
}
