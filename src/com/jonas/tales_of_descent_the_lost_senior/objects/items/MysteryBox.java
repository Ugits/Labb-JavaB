package com.jonas.tales_of_descent_the_lost_senior.objects.items;

import com.jonas.tales_of_descent_the_lost_senior.objects.Item;

public class MysteryBox extends Item {


    public MysteryBox() {
        super("Mystery Box", false);
    }

    @Override
    public void use() {
        super.use();
        //trigger store
    }
}
