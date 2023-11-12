package com.jonas.tales_of_descent_the_lost_senior.player;

import com.jonas.tales_of_descent_the_lost_senior.characters.heroes.Hero;
import com.jonas.tales_of_descent_the_lost_senior.objects.Item;
import com.jonas.tales_of_descent_the_lost_senior.objects.items.*;
import com.jonas.tales_of_descent_the_lost_senior.resources.OutputManipulation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;


public class Player {
    OutputManipulation console = new OutputManipulation();
    Hero hero = null;
    Hero friend1 = null;
    Hero friend2 = null;
    List<Item> inventory = new ArrayList<>();

    public Player() {
        initInventory();
    }

    public void initInventory() {
        inventory.add(new MysteryBox());
        inventory.add(new DungeonMap());
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

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public void printOwnedItems() {
        sortPrioOwnedItems();
        int index = 1;
        for (Item item : getInventory()) {
            if (item.isOwned()) {
                System.out.println(index + ". " + item.getName());
                index++;
            }
        }
    }

    public void printNotOwnedItems() {
        sortPrioNotOwnedItems();
        int index = 1;
        for (Item item : getInventory()) {
            if (!item.isOwned()) {
                System.out.println(index + ". " + item.getName());
                index++;
            }
        }
    }

    public void pickUpItem(String stringItem) {
        getInventory().forEach(item -> {
            if (Objects.equals(item.getName(), stringItem)) {
                item.setOwned(true);
            }
        });
    }

    //check whole list//player.getInventory().forEach(item -> System.out.println(item.getName()+item.isOwned()));
    public void printInventory() {
        getInventory().forEach(item -> System.out.println(item.getName() + " " + item.isOwned()));
    }

    public void sortPrioOwnedItems() {
        getInventory().sort(Comparator.comparing(Item::isOwned).reversed());
    }

    public void sortPrioNotOwnedItems() {
        getInventory().sort(Comparator.comparing(Item::isOwned));
    }

    public OutputManipulation getConsole() {
        return console;
    }

    public void setConsole(OutputManipulation console) {
        this.console = console;
    }


}
