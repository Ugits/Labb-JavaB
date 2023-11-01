package com.jonas.tales_of_descent_the_lost_senior.enviorment.startingarea;

import com.jonas.tales_of_descent_the_lost_senior.characters.heroes.Hero;
import com.jonas.tales_of_descent_the_lost_senior.characters.heroes.Knight;
import com.jonas.tales_of_descent_the_lost_senior.characters.heroes.Mage;
import com.jonas.tales_of_descent_the_lost_senior.characters.heroes.Ranger;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.Scene;
import com.jonas.tales_of_descent_the_lost_senior.player.Player;
import com.jonas.tales_of_descent_the_lost_senior.resources.InputProcessing;
import com.jonas.tales_of_descent_the_lost_senior.resources.OutputManipulation;

public class TheThreeFriends extends Scene {
    InputProcessing sc = new InputProcessing();
    OutputManipulation console = new OutputManipulation();
    Player player;

    public TheThreeFriends(Player player) throws InterruptedException {
        super(0, 0);
        this.player = player;
        description();
        part1();
        this.player.setHero(heroSwitch());
        part2();
    }



    public void description() throws InterruptedException {
        // "scene"
        console.printHeader(sceneHead);
        // scene description
        console.printDescription(theThreeFriendsDescription());
    }

    public void part1() throws InterruptedException {
        // friends by the fire
        console.printNarrative(PURPLE_ITALIC + "As the friends gather, a choice awaits. Whom will you take charge of in this quest?" + RESET);

        console.dialogIterator(theFriends);
    }

    public Hero heroSwitch() throws InterruptedException {
        Hero temp = null;
        while (temp == null) {

            console.delayPrint(80,"Choose wisely.. ");

            switch (sc.getScanner().nextLine()) {
                case "The Knight", "the knight", "Knight", "knight", "1", "Red", "red" -> temp = new Knight(knightHead, 100, 10, false);
                case "The Mage", "the mage", "Mage", "mage", "2", "Blue", "blue" -> temp = new Mage(mageHead, 100, 5, false);
                case "The Ranger", "the ranger", "Ranger", "ranger", "3", "Green", "green" -> temp = new Ranger(rangerHead, 100, 5, false);
                default -> console.printNarrative(PURPLE_ITALIC + "'Turning their marshmallows, the heroes waiting your call..'" + RESET);
            }
        }
        return temp;
    }

    public void part2() throws InterruptedException {
        // dialog continues
        console.br();
        System.out.println(player.getHero().getName());
        System.out.println("I'll take the lead. Our Master's missing, and we need to find out why.");
        console.br();
        console.printNarrative(PURPLE_ITALIC + "The trio decides to cover more ground, splitting up to search for clues. You will head towards the waterfall." + RESET);

        assignFriendHeroes(player);

        console.printHeader(player.getFriend1().getName());
        console.delayPrint(50,"Me and " + player.getFriend2().getName() + " will scout ahead.");
        console.br();

        console.printHeader(player.getFriend2().getName());
        console.delayPrint(50,"Let's meet back here later, be careful.");
        console.br();

        console.printNarrative("You venture into the forest alone." + RESET);

        console.sleep(3000);
    }

    public void assignFriendHeroes(Player player) {
        switch (player.getHero().getName()) {
            case knightHead -> {
                player.setFriend1(new Mage(mageHead, 100, 5, false));
                player.setFriend2(new Ranger(rangerHead, 100, 5, false));
            }
            case mageHead -> {
                player.setFriend1(new Ranger(rangerHead, 100, 5, false));
                player.setFriend2(new Knight(knightHead, 100, 10, false));
            }
            case rangerHead -> {
                player.setFriend1(new Mage(mageHead, 100, 5, false));
                player.setFriend2(new Knight(knightHead, 100, 10, false));
            }
        }

    }

}
