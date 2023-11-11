package com.jonas.tales_of_descent_the_lost_senior.resources;

import com.jonas.tales_of_descent_the_lost_senior.interaction.DiceSet;


import java.util.*;

public class CustomStrings implements IColors {

    // a class to print
    private final InputProcessing sc = new InputProcessing();
    public final String sceneHead = YELLOW_ITALIC + "SET SCENE NAME HERE" + RESET;
    public final String knightHead = RED_BOLD + "The Knight" + RESET;
    public final String mageHead = BLUE_BOLD + "The Mage" + RESET;
    public final String rangerHead = GREEN_BOLD + "The Ranger" + RESET;

    // SCENE: The Three Friends
    public String theThreeFriendsDescription() throws InterruptedException {
        return YELLOW_ITALIC + knightHead + ", " + mageHead + YELLOW_ITALIC + " and " + rangerHead + YELLOW_ITALIC + " are gathered around the campfire in the forest" + RESET;
    }

    //MENUS
    public String roomDescriptionExample = """ 
            This is a room
            """;

    public InputProcessing getSc() {
        return sc;
    }

}
