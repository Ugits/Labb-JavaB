package com.jonas.tales_of_descent_the_lost_senior.enviorment.startingarea;
import com.jonas.tales_of_descent_the_lost_senior.characters.heroes.Hero;
import com.jonas.tales_of_descent_the_lost_senior.characters.heroes.Knight;
import com.jonas.tales_of_descent_the_lost_senior.characters.heroes.Mage;
import com.jonas.tales_of_descent_the_lost_senior.characters.heroes.Ranger;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.Scene;
import com.jonas.tales_of_descent_the_lost_senior.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheThreeFriends extends Scene {

    public TheThreeFriends(Player player) throws InterruptedException {
        super(player,0, 0);
        setDescription(theThreeFriendsDescription());
        description();
        part1();
        getPlayer().setHero(heroSwitch());
        part2();
    }

    @Override
    public void description() throws InterruptedException {
        getConsole().printHeader(sceneHead);
        getConsole().printScene(getDescription());
    }



    public List<String> theFriends = new ArrayList<>(Arrays.asList(
            knightHead, "The stalwart defender, skilled with the blade and armored against danger.",
            mageHead, "The wielder of arcane powers, knowledgeable in the mysteries of the world.",
            rangerHead, "The swift and skilled tracker, attuned to the secrets of the forest."));


    public void part1() throws InterruptedException {
        // friends by the fire
        getConsole().printNarrative(PURPLE_ITALIC + "As the friends gather, a choice awaits. Whom will you take charge of in this quest?" + RESET);
        getConsole().dialogIterator(theFriends);
    }

    public Hero heroSwitch() throws InterruptedException {
        Hero temp = null;
        while (temp == null) {

            getConsole().delayPrint(80,"Choose wisely.. ");

            switch (getSc().getScanner().nextLine()) {
                case "The Knight", "the knight", "Knight", "knight", "1", "Red", "red" -> temp = new Knight(knightHead);
                case "The Mage", "the mage", "Mage", "mage", "2", "Blue", "blue" -> temp = new Mage(mageHead);
                case "The Ranger", "the ranger", "Ranger", "ranger", "3", "Green", "green" -> temp = new Ranger(rangerHead);
                default -> getConsole().printNarrative(PURPLE_ITALIC + "'Turning their marshmallows, the heroes waiting your call..'" + RESET);
            }
        }
        return temp;
    }

    public void part2() throws InterruptedException {
        // dialog continues
        getConsole().br();
        System.out.println(getPlayer().getHero().getName());
        System.out.println("I'll take the lead. Our Master's missing, and we need to find out why.");
        getConsole().br();
        getConsole().printNarrative(PURPLE_ITALIC + "The trio decides to cover more ground, splitting up to search for clues. You will head towards the waterfall." + RESET);

        assignFriendHeroes(getPlayer());

        getConsole().printHeader(getPlayer().getFriend1().getName());
        getConsole().delayPrint(50,"Me and " + getPlayer().getFriend2().getName() + " will scout ahead.");
        getConsole().br();

        getConsole().printHeader(getPlayer().getFriend2().getName());
        getConsole().delayPrint(50,"Let's meet back here later, be careful.");
        getConsole().br();

        getConsole().printNarrative("You venture into the forest alone." + RESET);

        getConsole().sleep(3000);
    }

    public void assignFriendHeroes(Player player) {
        switch (player.getHero().getName()) {
            case knightHead -> {
                player.setFriend1(new Mage(mageHead));
                player.setFriend2(new Ranger(rangerHead));
            }
            case mageHead -> {
                player.setFriend1(new Ranger(rangerHead));
                player.setFriend2(new Knight(knightHead));
            }
            case rangerHead -> {
                player.setFriend1(new Mage(mageHead));
                player.setFriend2(new Knight(knightHead));
            }
        }
    }
}
