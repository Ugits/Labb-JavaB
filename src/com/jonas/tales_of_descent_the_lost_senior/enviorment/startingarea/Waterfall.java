package com.jonas.tales_of_descent_the_lost_senior.enviorment.startingarea;
import com.jonas.tales_of_descent_the_lost_senior.characters.heroes.Knight;
import com.jonas.tales_of_descent_the_lost_senior.characters.heroes.Mage;
import com.jonas.tales_of_descent_the_lost_senior.characters.heroes.Ranger;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.Scene;
import com.jonas.tales_of_descent_the_lost_senior.objects.items.MysteryBox;
import com.jonas.tales_of_descent_the_lost_senior.player.Player;
import com.jonas.tales_of_descent_the_lost_senior.resources.InputProcessing;
import com.jonas.tales_of_descent_the_lost_senior.resources.OutputManipulation;

import java.util.Locale;
import java.util.Objects;

public class Waterfall extends Scene {
    InputProcessing sc = new InputProcessing();
    OutputManipulation console = new OutputManipulation();
    Player player;
    public Waterfall(Player player) throws InterruptedException {
        super(0, 0);
        this.player = player;
        description();
        part1();
    }

    public void description() throws InterruptedException {
        // "scene"
        console.printHeader(sceneHead);
        // scene description
        console.printDescription(waterfallDescription(player.getHero().getName()));
    }

    public void part1() throws InterruptedException {
        console.printNarrative("The cascade roars, shrouded in mystery. You find yourself standing alone before the powerful waterfall. The air is thick with the spray of the water, the ground damp beneath your feet.");

        console.printHeader(player.getHero().getName());
        console.delayPrint(50,
                """
                        This place is something else.\s
                        What lies beyond is a mystery.\s
                        I must proceed carefully.""");
        console.br();
        console.printNarrative("Wading through the water, feeling the mist on your face, cautiously approaching the edge of the waterfall...");
        console.br();
        console.printHeader(player.getHero().getName());
        console.delayPrint(500,"...");
        console.sleep(1000);
        console.delayPrint(200,"what's that...");
        console.br();
        console.printNarrative("Gazing down through the shrouded surface, your eyes meets this shimmer of reflections...");
        console.printNarrative("Is it something there?");

        console.printHeader(player.getHero().getName());
        console.println("1. Reach down");
        console.println("2. Don't bother");
        switch (sc.getScanner().nextLine()) {
            case "1", "reach down", "Reach down"  -> pickUpMysteryBox();
            case "2", "Don't bother", "don't bother" -> {
                console.printNarrative("Irrationally, you ignore the mystery, a mystery that might had been of importance... ");
                console.printNarrative("anyway... lets continue!");
            }
            default -> console.printNarrative(PURPLE_ITALIC + "Our hero, " + player.getHero().getName()+ ", seams almost paralyzed by the sight. What will he do?" + RESET);
        }
    }

    public void pickUpMysteryBox(){
        System.out.println("You found a mystery box");
        player.pickUpItem("Mystery Box");

        player.printOwnedItems();
        player.printNotOwnedItems();


    }



}
