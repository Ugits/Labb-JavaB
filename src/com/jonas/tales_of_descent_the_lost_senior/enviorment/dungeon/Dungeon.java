package com.jonas.tales_of_descent_the_lost_senior.enviorment.dungeon;

import com.jonas.tales_of_descent_the_lost_senior.Game;
import com.jonas.tales_of_descent_the_lost_senior.characters.Character;
import com.jonas.tales_of_descent_the_lost_senior.resources.OutputManipulation;

import java.util.*;
import java.util.stream.IntStream;

// TODO: 2023-10-26  Iterate over 1 floor, add floorDifficulty by constructor
public class Dungeon extends OutputManipulation {
    //int floorNum;
    List<Room> floor = new ArrayList<>(5);
    Character hero;


    public Dungeon(Character hero, int floor, Game game) {
        setHero(hero);

        IntStream.range(1, 6).forEach(i -> this.floor.add(new Room(getHero(), floor, i,game)));
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
    }

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
