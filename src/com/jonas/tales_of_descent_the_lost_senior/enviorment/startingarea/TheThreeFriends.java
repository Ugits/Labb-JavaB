package com.jonas.tales_of_descent_the_lost_senior.enviorment.startingarea;
import com.jonas.tales_of_descent_the_lost_senior.characters.hero.Hero;
import com.jonas.tales_of_descent_the_lost_senior.characters.hero.models.Knight;
import com.jonas.tales_of_descent_the_lost_senior.characters.hero.models.Mage;
import com.jonas.tales_of_descent_the_lost_senior.characters.hero.models.Ranger;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.Scene;
import com.jonas.tales_of_descent_the_lost_senior.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheThreeFriends extends Scene {

    Player player;

    public TheThreeFriends(Player player)  {
        super(player,0, 0);
        setPlayer(player);
        setDescription(getOut().theThreeFriendsDescription());
        description();
        part1();
        getPlayer().setHero(heroSwitch());
        part2();
    }

    @Override
    public void description() {
        getOut().printHeader(getOut().sceneHead);
        getOut().printScene(getDescription());
    }



    public List<String> theFriends = new ArrayList<>(Arrays.asList(
            getOut().knightHead, "The stalwart defender, skilled with the blade and armored against danger.",
            getOut().mageHead, "The wielder of arcane powers, knowledgeable in the mysteries of the world.",
            getOut().rangerHead, "The swift and skilled tracker, attuned to the secrets of the forest."));


    public void part1() {
        // friends by the fire
        getOut().printNarrative(PURPLE_ITALIC + "As the friends gather, a choice awaits. Whom will you take charge of in this quest?" + RESET);
        getOut().dialogIterator(theFriends);
    }

    public Hero heroSwitch() {
        Hero temp = null;
        while (temp == null) {

            getOut().delayPrint(80,"Choose wisely.. ");

            switch (getSc().getScanner().nextLine()) {
                case "The Knight", "the knight", "Knight", "knight", "1", "Red", "red" -> temp = new Knight();
                case "The Mage", "the mage", "Mage", "mage", "2", "Blue", "blue" -> temp = new Mage();
                case "The Ranger", "the ranger", "Ranger", "ranger", "3", "Green", "green" -> temp = new Ranger();
                default -> getOut().printNarrative(PURPLE_ITALIC + "'Turning their marshmallows, the heroes waiting your call..'" + RESET);
            }
        }
        return temp;
    }

    public void part2()  {

        System.out.println(getPlayer().getHero().getName());
        // dialog continues
        getOut().br();
        System.out.println(getPlayer().getHero().getName());
        System.out.println("I'll take the lead. Our Master's missing, and we need to find out why.");
        getOut().br();
        getOut().printNarrative(PURPLE_ITALIC + "The trio decides to cover more ground, splitting up to search for clues. You will head towards the waterfall." + RESET);

        assignFriendHeroes();

        getOut().printHeader(getPlayer().getFriend1().getName());
        getOut().delayPrint(50,"Me and " + getPlayer().getFriend2().getName() + " will scout ahead.");
        getOut().br();

        getOut().printHeader(getPlayer().getFriend2().getName());
        getOut().delayPrint(50,"Let's meet back here later, be careful.");
        getOut().br();

        getOut().printNarrative("You venture into the forest alone." + RESET);

        getOut().sleep(3000);
    }

    public void assignFriendHeroes() {
        switch (getPlayer().getHero().getName()) {
            case RED_BOLD + "The Knight" + RESET -> {
                getPlayer().setFriend1(new Mage());
                getPlayer().setFriend2(new Ranger());
            }
            case  BLUE_BOLD + "The Mage" + RESET -> {
                getPlayer().setFriend1(new Ranger());
                getPlayer().setFriend2(new Knight());
            }
            case GREEN_BOLD + "The Ranger" + RESET -> {
                getPlayer().setFriend1(new Mage());
                getPlayer().setFriend2(new Knight());
            }
        }
    }


    //GET n SET

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
