package com.jonas.tales_of_descent_the_lost_senior.objects.items;

import com.jonas.tales_of_descent_the_lost_senior.Game;
import com.jonas.tales_of_descent_the_lost_senior.objects.Item;

public class DungeonMap extends Item {

    public DungeonMap(Boolean owned) {
        super("Dungeon Map", owned);
    }
    public DungeonMap() {
        super("Dungeon Map", false);
    }

    @Override
    public void use() {
        getGame().getMap().printMap();
        System.out.println("useee MAAP");
    }


}
