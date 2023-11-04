package com.jonas.tales_of_descent_the_lost_senior.enviorment.dungeon;

import com.jonas.tales_of_descent_the_lost_senior.characters.monsters.Goblin;
import com.jonas.tales_of_descent_the_lost_senior.characters.monsters.Monster;
import com.jonas.tales_of_descent_the_lost_senior.characters.monsters.NoMonster;
import com.jonas.tales_of_descent_the_lost_senior.characters.monsters.PackOfRats;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.Scene;
import com.jonas.tales_of_descent_the_lost_senior.interaction.DiceSet;
import com.jonas.tales_of_descent_the_lost_senior.player.Player;


public class Room extends Scene {

    //public boolean hasMonster;
    public int difficulty;
    public int onFloor;
    public int num;
    public boolean hasStore;
    public boolean hasTreasure;
    public boolean hasMonster;
    public Monster monster;

    public Room(Player player, int floorNum, int roomNum) {
        super(player, -floorNum, -floorNum);
        this.difficulty = floorNum;
        this.onFloor = floorNum;
        this.num = roomNum;

        DiceSet roll = new DiceSet();
        // roll for has monster, if true, assign monster
        this.monster = (roll.d20() > 12) ? fetchMonster(roll.dCustom(2)) : new NoMonster(); // Abstract clas cant be null?

        // has store todo implement store

        // has tressure todo modify with LUCK //
        this.hasTreasure = roll.d20() > 16;

        // set description
        setDescription(roomDescriptionGenerator());



    }

    @Override
    public void runScene() {

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

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getOnFloor() {
        return onFloor;
    }

    public void setOnFloor(int onFloor) {
        this.onFloor = onFloor;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isHasStore() {
        return hasStore;
    }

    public void setHasStore(boolean hasStore) {
        this.hasStore = hasStore;
    }

    public boolean isHasTreasure() {
        return hasTreasure;
    }

    public void setHasTreasure(boolean hasTreasure) {
        this.hasTreasure = hasTreasure;
    }

    public boolean isHasMonster() {
        return hasMonster;
    }

    public void setHasMonster(boolean hasMonster) {
        this.hasMonster = hasMonster;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }


}
