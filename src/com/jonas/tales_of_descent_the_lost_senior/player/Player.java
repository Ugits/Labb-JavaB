package com.jonas.tales_of_descent_the_lost_senior.player;

import com.jonas.tales_of_descent_the_lost_senior.characters.heroes.Hero;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    Hero hero = null;
    Hero friend1 = null;
    Hero friend2 = null;
    HashMap<String,Boolean> inventory = new HashMap<>();

    public Player() {
        inventory.put("Mystery Box", false);
    }




    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Hero getFriend1() {
        return friend1;
    }

    public void setFriend1(Hero friend1) {
        this.friend1 = friend1;
    }

    public Hero getFriend2() {
        return friend2;
    }

    public void setFriend2(Hero friend2) {
        this.friend2 = friend2;
    }

    public HashMap<String, Boolean> getInventory() {
        return inventory;
    }

    public void setInventory(HashMap<String, Boolean> inventory) {
        this.inventory = inventory;
    }
}
