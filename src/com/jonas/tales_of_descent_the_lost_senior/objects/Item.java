package com.jonas.tales_of_descent_the_lost_senior.objects;

import com.jonas.tales_of_descent_the_lost_senior.Game;
import com.jonas.tales_of_descent_the_lost_senior.characters.hero.Hero;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.Scene;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.dungeon.Dungeon;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.dungeon.Room;
import com.jonas.tales_of_descent_the_lost_senior.resources.InputProcessing;
import com.jonas.tales_of_descent_the_lost_senior.resources.MenuTool;
import com.jonas.tales_of_descent_the_lost_senior.resources.OutputManipulation;

public abstract class Item {
    InputProcessing sc = new InputProcessing();
    OutputManipulation out = new OutputManipulation();

    private String name;
    private int price;
    private boolean owned;


    public Item(String name, int price, boolean owned) {
        this.name = name;
        this.price = price;
        this.owned = owned;
    }

    public void use(Game game) {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }


    public InputProcessing getSc() {
        return sc;
    }

    public void setSc(InputProcessing sc) {
        this.sc = sc;
    }

    public OutputManipulation getOut() {
        return out;
    }

    public void setOut(OutputManipulation out) {
        this.out = out;
    }


}


