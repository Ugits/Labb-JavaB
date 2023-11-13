package com.jonas.tales_of_descent_the_lost_senior.enviorment.dungeon;

import com.jonas.tales_of_descent_the_lost_senior.characters.Character;
import com.jonas.tales_of_descent_the_lost_senior.player.Player;
import com.jonas.tales_of_descent_the_lost_senior.resources.OutputManipulation;

import java.util.*;
import java.util.stream.IntStream;

// TODO: 2023-10-26  Iterate over 1 floor, add floorDifficulty by constructor
public class Dungeon extends OutputManipulation {
    //int floorNum;
    List<Room> floor = new ArrayList<>(5);
    Character hero;

    /**
     * List<Room> floor1 = new ArrayList<>(5);
     * List<Room> floor2 = new ArrayList<>(5);
     * List<Room> floor3 = new ArrayList<>(5);
     * List<Room> floor4 = new ArrayList<>(5);
     * List<Room> floor5 = new ArrayList<>(5);
     * List<Room> floor6 = new ArrayList<>(5);
     * List<Room> floor7 = new ArrayList<>(5);
     * List<Room> floor8 = new ArrayList<>(5);
     * List<Room> floor9 = new ArrayList<>(5);
     * List<Room> floor10 = new ArrayList<>(5);
     */

    public Dungeon(Character hero, int floor) {
        setHero(hero);

        /**
         * IntStream.range(0, 5).forEach(i -> this.floor1.add(new Room(1, i + 1)));
         IntStream.range(0, 5).forEach(i -> this.floor2.add(new Room(2, i + 1)));
         IntStream.range(0, 5).forEach(i -> this.floor3.add(new Room(3, i + 1)));
         IntStream.range(0, 5).forEach(i -> this.floor4.add(new Room(4, i + 1)));
         IntStream.range(0, 5).forEach(i -> this.floor5.add(new Room(5, i + 1)));
         IntStream.range(0, 5).forEach(i -> this.floor6.add(new Room(6, i + 1)));
         IntStream.range(0, 5).forEach(i -> this.floor7.add(new Room(7, i + 1)));
         IntStream.range(0, 5).forEach(i -> this.floor8.add(new Room(8, i + 1)));
         IntStream.range(0, 5).forEach(i -> this.floor9.add(new Room(9, i + 1)));
         IntStream.range(0, 5).forEach(i -> this.floor10.add(new Room(10, i + 1)));
         */

        //if floor is == 5 print story, ("starting to get closer")
        IntStream.range(1, 6).forEach(i -> this.floor.add(new Room(getHero(), floor, i)));

        System.out.println("creating floor"+ "[DEBUG]");
    }

    public void printMap() {

        List<String> mapOverview2 = new ArrayList<>(Arrays.asList("", "", "", "", ""));

        IntStream.range(0, getFloor().size()).forEach(i -> {
            if ((getFloor().get(i).isHasMonster()) && (getFloor().get(i).isHasTreasure())) {
                mapOverview2.set(i, BLACK_BACKGROUND + RED_BOLD + "[" + YELLOW_BOLD_BRIGHT + "?" + RED_BOLD + "] " + RESET);
            } else if ((getFloor().get(i).isHasMonster()) && !(getFloor().get(i).isHasTreasure())) {
                mapOverview2.set(i, BLACK_BACKGROUND + RED_BOLD + "[ ] " + RESET);
            } else if (!(getFloor().get(i).isHasMonster()) && (getFloor().get(i).isHasTreasure())) {
                mapOverview2.set(i, BLACK_BACKGROUND + "[" + YELLOW_BOLD_BRIGHT + "?" + RESET + BLACK_BACKGROUND + "] " + RESET);
            } else {
                mapOverview2.set(i, BLACK_BACKGROUND + "[ ] " + RESET);
            }
        });
        //System.out.println(GREEN_UNDERLINED + "▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒" + RESET);
        System.out.println(BLACK_BACKGROUND + "┘          " + WHITE_BOLD_BRIGHT + "-MAP-" + "          └" + RESET);
        System.out.print(BLACK_BACKGROUND + "   " + RESET);
        System.out.print(BLACK_BACKGROUND + " " + RESET);
        System.out.print(String.join("", mapOverview2));
        System.out.println(BLACK_BACKGROUND + "   " + RESET);
        System.out.println(BLACK_BACKGROUND + "┐                         ┌" + RESET);

        /**
         *  List<String> mapOverview = new ArrayList<>(Arrays.asList("[", "[", "[", "[", "["));

         IntStream.range(0, getFloor().size()).forEach(i -> {
         if (getFloor().get(i).isHasMonster()) {
         mapOverview.set(i, mapOverview.get(i) + RED + "!" + RESET);
         } else {
         mapOverview.set(i, mapOverview.get(i) + " ");
         }
         if (getFloor().get(i).isHasTreasure()) {
         mapOverview.set(i, mapOverview.get(i) + YELLOW_BOLD_BRIGHT + "?" + RESET);
         } else {
         mapOverview.set(i, mapOverview.get(i) + " ");
         }
         mapOverview.set(i, mapOverview.get(i) + "]");
         });
         System.out.println(String.join("", mapOverview));
         */
    }







    /**
     * public List<Room> getFloor1() {
     return floor1;
     }

     public List<Room> getFloor2() {
     return floor2;
     }

     public List<Room> getFloor3() {
     return floor3;
     }

     public List<Room> getFloor4() {
     return floor4;
     }

     public List<Room> getFloor5() {
     return floor5;
     }

     public List<Room> getFloor6() {
     return floor6;
     }

     public List<Room> getFloor7() {
     return floor7;
     }

     public List<Room> getFloor8() {
     return floor8;
     }

     public List<Room> getFloor9() {
     return floor9;
     }

     public List<Room> getFloor10() {
     return floor10;
     }
     */

    //GET n SET

    public void setFloor(List<Room> floor) {
        this.floor = floor;
    }
    public List<Room> getFloor() {
        return floor;
    }

    public Character getHero() {
        return hero;
    }
    public void setHero(Character hero) {
        this.hero = hero;
    }
}
