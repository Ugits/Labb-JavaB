package com.jonas.tales_of_descent_the_lost_senior.enviorment.dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Map {
    List<Room> floor1 = new ArrayList<>(5);
    List<Room> floor2 = new ArrayList<>(5);
    List<Room> floor3 = new ArrayList<>(5);
    List<Room> floor4 = new ArrayList<>(5);
    List<Room> floor5 = new ArrayList<>(5);
    List<Room> floor6 = new ArrayList<>(5);
    List<Room> floor7 = new ArrayList<>(5);
    List<Room> floor8 = new ArrayList<>(5);
    List<Room> floor9 = new ArrayList<>(5);
    List<Room> floor10 = new ArrayList<>(5);

    public Map() {
        IntStream.range(0, 5).forEach(i -> this.floor1.add(new Room(1, i + 1)));
        IntStream.range(0, 5).forEach(i -> this.floor2.add(new Room(2, i + 1)));
        IntStream.range(0, 5).forEach(i -> this.floor3.add(new Room(3, i + 1)));
        IntStream.range(0, 5).forEach(i -> this.floor4.add(new Room(4, i + 1)));
        IntStream.range(0, 5).forEach(i -> this.floor5.add(new Room(5, i + 1)));
        IntStream.range(0, 5).forEach(i -> this.floor6.add(new Room(6, i + 1)));
        IntStream.range(0, 5).forEach(i -> this.floor7.add(new Room(7, i + 1)));
        IntStream.range(0, 5).forEach(i -> this.floor8.add(new Room(8, i + 1)));
        IntStream.range(0, 5).forEach(i -> this.floor9.add(new Room(9, i + 1)));
        IntStream.range(0, 5).forEach(i -> this.floor10.add(new Room(10, i + 1)));
    }

    public List<Room> getFloor1() {
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
}