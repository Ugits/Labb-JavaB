package com.jonas.tales_of_descent_the_lost_senior.enviorment.startingarea;

import com.jonas.tales_of_descent_the_lost_senior.enviorment.Scene;
import com.jonas.tales_of_descent_the_lost_senior.player.Player;

public class Waterfall extends Scene {

    public Waterfall(Player player) throws InterruptedException {
        super(player, 0, 0);
        setDescription(waterfallDescription(getPlayer()));
        description();
        part1();
    }

    @Override
    public void description() throws InterruptedException {
        getConsole().printHeader(getConsole().sceneHead);
        getConsole().printScene(getDescription());
    }

    // Waterfall
    public String waterfallDescription(Player player) throws InterruptedException {
        return YELLOW_ITALIC + player.getHero().getName() + YELLOW_ITALIC + ", having navigated alone, arrives at the base of the waterfall" + RESET;
    }

    public void part1() throws InterruptedException {
        getConsole().printNarrative("The cascade roars, shrouded in mystery. You find yourself standing alone before the powerful waterfall. The air is thick with the spray of the water, the ground damp beneath your feet.");

        getConsole().printHeader(getPlayer().getHero().getName());
        getConsole().delayPrint(50,
                """
                        This place is something else.\s
                        What lies beyond is a mystery.\s
                        I must proceed carefully.""");
        getConsole().br();
        getConsole().printNarrative("Wading through the water, feeling the mist on your face, cautiously approaching the edge of the waterfall...");
        getConsole().br();
        getConsole().printHeader(getPlayer().getHero().getName());
        getConsole().delayPrint(500, "...");
        getConsole().sleep(1000);
        getConsole().delayPrint(200, "what's that...");
        getConsole().br();
        getConsole().printNarrative("Gazing down through the shrouded surface, your eyes meets this shimmer of reflections...");
        getConsole().printNarrative("Is it something there?");

        getConsole().printHeader(getPlayer().getHero().getName());
        boolean loop = true;
        while (loop) {
            getConsole().println("1. Reach down");
            getConsole().println("2. Don't bother");
            switch (getSc().getScanner().nextLine()) {
                case "1", "reach down", "Reach down" -> {
                    pickUpMysteryBox();
                    continueWithBox();
                    loop = false;
                }
                case "2", "Don't bother", "don't bother" -> {
                    continueWithoutBox();
                    loop = false;
                }
                default ->
                        getConsole().printNarrative(PURPLE_ITALIC + "Our hero, " + getPlayer().getHero().getName() + PURPLE_ITALIC + ", seams almost paralyzed by the sight. What will he do?" + RESET);
            }
        }
        getConsole().br();
        getConsole().printNarrative("Your heart is racing with anticipation, you move closer to the concealed passage behind the waterfall, ready to uncover what lies beyond.");
    }

    public void pickUpMysteryBox() {
        getPlayer().pickUpItem("Mystery Box");
    }

    public void continueWithBox() throws InterruptedException {
        getConsole().printNarrative("Fitting in your palm, you now hold a metallic silver cube, with flawless reflective surfaces, and surprisingly lightweight.");
        getConsole().printHeader(getPlayer().getHero().getName());
        getConsole().delayPrint(0, "Might this be a lead to my master..");
    }

    public void continueWithoutBox() throws InterruptedException {
        getConsole().printNarrative("Irrationally, you ignore the mystery, a mystery that might had been of importance... ");
        getConsole().printNarrative("anyway... lets continue!");
    }

}
