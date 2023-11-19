package com.jonas.tales_of_descent_the_lost_senior.objects.items;

import com.jonas.tales_of_descent_the_lost_senior.Game;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.dungeon.Dungeon;
import com.jonas.tales_of_descent_the_lost_senior.objects.Item;

public class DungeonMap extends Item {

    public DungeonMap(Boolean owned) {
        super("Dungeon Map",30, owned);
    }
    public DungeonMap() {
        super("Dungeon Map",30, false);
    }

    @Override
    public void use(Game game) {
       game.getMap().printMap();
    }



}
