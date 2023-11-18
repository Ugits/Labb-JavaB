package com.jonas.tales_of_descent_the_lost_senior.objects;

import com.jonas.tales_of_descent_the_lost_senior.Game;
import com.jonas.tales_of_descent_the_lost_senior.characters.hero.Hero;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.Scene;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.dungeon.Dungeon;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.dungeon.Room;
import com.jonas.tales_of_descent_the_lost_senior.resources.MenuTool;

public abstract class Item extends MenuTool {
    private String name;
    private boolean owned;


    public Item(String name, boolean owned) {
        this.name = name;
        this.owned = owned;
    }

    public void use() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }


}


