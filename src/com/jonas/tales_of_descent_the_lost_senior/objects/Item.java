package com.jonas.tales_of_descent_the_lost_senior.objects;

public abstract class Item {
    String name;
    boolean owned;


    public Item(String name, boolean owned) {
        this.name = name;
        this.owned = owned;
    }

    public void use(){
        System.out.println("use item");
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
