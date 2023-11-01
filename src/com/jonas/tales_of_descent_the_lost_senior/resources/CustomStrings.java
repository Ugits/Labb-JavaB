package com.jonas.tales_of_descent_the_lost_senior.resources;

import com.jonas.tales_of_descent_the_lost_senior.interaction.DiceSet;


import java.util.*;

public class CustomStrings implements IColors {
    // a class to print
    private final InputProcessing sc = new InputProcessing();
    public final String sceneHead = YELLOW_ITALIC + "Scene" + RESET;
    public final String knightHead = RED_BOLD + "The Knight" + RESET;
    public final String mageHead = BLUE_BOLD + "The Mage" + RESET;
    public final String rangerHead = GREEN_BOLD + "The Ranger" + RESET;

    //Intro
    // SCENE: The Three Friends
    public String theThreeFriendsDescription() throws InterruptedException {
        return YELLOW_ITALIC + knightHead + ", " + mageHead + YELLOW_ITALIC + " and " + rangerHead + YELLOW_ITALIC + " are gathered around the campfire in the forest" + RESET;
    }

    public List<String> theFriends = new ArrayList<>(Arrays.asList(
            knightHead, "The stalwart defender, skilled with the blade and armored against danger.",
            mageHead, "The wielder of arcane powers, knowledgeable in the mysteries of the world.",
            rangerHead, "The swift and skilled tracker, attuned to the secrets of the forest."));

    // Waterfall
    public String waterfallDescription(String hero) throws InterruptedException {
        return YELLOW_ITALIC + hero + YELLOW_ITALIC + ", having navigated alone, arrives at the base of the waterfall" + RESET;
    }

    //Into The Dark
    public final String intoTheDarkDescription = """
            You just came throughout the waterfall opening you eyes. You take a few steps,
            into the stripes of light that leaks from the cracked open ceiling.
            you see a trail of lit torches along the walls. Now theres no turning back.
            While flickering fire leads you down the hall, you suddenly notice an updraft wind, you stopped.
            Slowly, you look down, and there is nothing there. nothing but an endless fall to death.
            While thinking that you just consumed the last bit of luck, you see two poles sticking up by your feet.
            Trying to figure out how long a climb would be.
            The ladder is fading out while scooping down the darkness, you realize, its also the only option to get to were you need.
                                    
            So you descend, the wooden craft you climb feels pretty sturdy.
            As you emerge, you try to project comfort upon yourself by saying..
            "this ain't so bad..."
            but... *sniff* *sniff*
            what is that?...
            ... rotten meat?
                            
            Reaching solid ground, you turn around..
            """;


    public String roomDescriptionGenerator() {
        DiceSet roll = new DiceSet();

        return switch (roll.d20()) {
            case 1 -> "description 1";
            case 2 -> "description 2";
            case 3 -> "description 3";
            case 4 -> "description 4";
            case 5 -> "description 5";
            case 6 -> "description 6";
            case 7 -> "description 7";
            case 8 -> "description 8";
            case 9 -> "description 9";
            case 10 -> "description 10";
            case 11 -> "description 11";
            case 12 -> "description 12";
            case 13 -> "description 13";
            case 14 -> "description 14";
            case 15 -> "description 15";
            case 16 -> "description 16";
            case 17 -> "description 17";
            case 18 -> "description 18";
            case 19 -> "description 19";
            case 20 -> "description 20";
            default -> throw new IllegalStateException("Unexpected value: " + roll.d20());
        };

    }

    //MENUS
    public String roomDescriptionExample = """ 
            This is a room
            """;

    public String actionMenu = """ 
            Actions:
            1. Move Deeper
            2. Search Room
            3. Inventory
            4. Character Stats
                            
            """;

    public String combatMenu = """
            1. Hit
            2. Parry Next
            3. Escape
            """;
}
