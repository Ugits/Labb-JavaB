package com.jonas.tales_of_descent_the_lost_senior.enviorment.startingarea;

import com.jonas.tales_of_descent_the_lost_senior.enviorment.Scene;
import com.jonas.tales_of_descent_the_lost_senior.player.Player;

public class Waterfall extends Scene {

    public Waterfall(Player player)  {
        super(player, 0, 0);
        setDescription(waterfallDescription(getPlayer()));
        description();
        part1();
    }

    @Override
    public void description() {
        getOut().printHeader(getOut().sceneHead);
        getOut().printScene(getDescription());
    }

    // Waterfall
    public String waterfallDescription(Player player) {
        return YELLOW_ITALIC + player.getHero().getName() + YELLOW_ITALIC + ", having navigated alone, arrives at the base of the waterfall" + RESET;
    }

    public void part1()  {
        getOut().printNarrative("The cascade roars, shrouded in mystery. You find yourself standing alone before the powerful waterfall. The air is thick with the spray of the water, the ground damp beneath your feet.");

        getOut().printHeader(getPlayer().getHero().getName());
        getOut().delayPrint(50,
                """
                        This place is something else.\s
                        What lies beyond is a mystery.\s
                        I must proceed carefully.""");
        getOut().br();
        getOut().printNarrative("Wading through the water, feeling the mist on your face, cautiously approaching the edge of the waterfall...");
        getOut().br();
        getOut().printHeader(getPlayer().getHero().getName());
        getOut().delayPrint(500, "...");
        getOut().sleep(1000);
        getOut().delayPrint(200, "what's that...");
        getOut().br();
        getOut().printNarrative("Gazing down through the shrouded surface, your eyes meets this shimmer of reflections...");
        getOut().printNarrative("Is it something there?");

        getOut().printHeader(getPlayer().getHero().getName());
        boolean loop = true;
        while (loop) {
            getOut().println("1. Reach down");
            getOut().println("2. Don't bother");
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
                        getOut().printNarrative(PURPLE_ITALIC + "Our hero, " + getPlayer().getHero().getName() + PURPLE_ITALIC + ", seams almost paralyzed by the sight. What will he do?" + RESET);
            }
        }
        getOut().br();
        getOut().printNarrative("Your heart is racing with anticipation, you move closer to the concealed passage behind the waterfall, ready to uncover what lies beyond.");
    }

    public void pickUpMysteryBox() {
        getPlayer().getHero().pickUpItem("Mystery Box");
    }

    public void continueWithBox()  {
        getOut().printNarrative("Fitting in your palm, you now hold a metallic silver cube, with flawless reflective surfaces, and surprisingly lightweight.");
        getOut().printHeader(getPlayer().getHero().getName());
        getOut().delayPrint(0, "Might this be a lead to my master..");
    }

    public void continueWithoutBox() {
        getOut().printNarrative("Irrationally, you ignore the mystery, a mystery that might had been of importance... ");
        getOut().printNarrative("anyway... lets continue!");
    }

}
