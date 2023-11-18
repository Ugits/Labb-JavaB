package com.jonas.tales_of_descent_the_lost_senior.objects.items;

import com.jonas.tales_of_descent_the_lost_senior.objects.Item;

public class MysteryBox extends Item {


    public MysteryBox(Boolean owned) {
        super("Mystery Box", owned);
    }
    public MysteryBox() {
        super("Mystery Box", false);
    }

    @Override
    public void use() {
      //Trigger store
        // TODO: 2023-11-18 Build store
        // init all items in hero
        // call them from menu tool
        // item abilitys, keep in every Item, if possible
    }

    // build store
}
