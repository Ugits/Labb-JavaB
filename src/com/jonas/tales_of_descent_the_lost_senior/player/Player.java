package com.jonas.tales_of_descent_the_lost_senior.player;

import com.jonas.tales_of_descent_the_lost_senior.characters.Character;



public class Player {

    Character hero = null;
    Character friend1 = null;
    Character friend2 = null;
    //List<Item> inventory = new ArrayList<>();

    public Player() {
        //initInventory();
    }

    /**
     * public void initInventory() {
         inventory.add(new MysteryBox());
         inventory.add(new DungeonMap());
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

     */



    //GET n SET
    public Character getHero() {
        return hero;
    }
    public void setHero(Character hero) {
        this.hero = hero;
    }

    public Character getFriend1() {
        return friend1;
    }
    public void setFriend1(Character friend1) {
        this.friend1 = friend1;
    }

    public Character getFriend2() {
        return friend2;
    }
    public void setFriend2(Character friend2) {
        this.friend2 = friend2;
    }





}
