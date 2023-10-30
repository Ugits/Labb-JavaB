package com.jonas.tales_of_descent_the_lost_senior.enviorment.startingarea;

import com.jonas.tales_of_descent_the_lost_senior.characters.heroes.Hero;
import com.jonas.tales_of_descent_the_lost_senior.characters.heroes.Knight;
import com.jonas.tales_of_descent_the_lost_senior.characters.heroes.Mage;
import com.jonas.tales_of_descent_the_lost_senior.characters.heroes.Ranger;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.Scene;
import com.jonas.tales_of_descent_the_lost_senior.player.Player;
import com.jonas.tales_of_descent_the_lost_senior.resources.InputProcessing;

public class TheThreeFriends extends Scene {
    InputProcessing sc = new InputProcessing();

    public TheThreeFriends() {
        super(0, 0);
        setDescription(theThreeFriendsDescription);
    }

    public void description() throws InterruptedException {
        // "scene"
        scene(sceneHead);
        // scene description
        scene(getDescription());
    }

    public void part1() throws InterruptedException {
        // friends by the fire
        narrator(PURPLE_ITALIC + "'As the friends gather, a choice awaits. Whom will you take charge of in this quest?'" + RESET);
        br();
        br();
        dialogIterator(theFriends);
    }

    public Hero heroSwitch() throws InterruptedException {
        Hero temp = null;
        while (temp == null) {
            br();
            print("I will choose, The.. ");

            switch (sc.getScanner().nextLine()) {
                case "Knight", "knight", "1", "Red", "red" -> temp = new Knight(knightHead, 100, 10, false);
                case "Mage", "mage", "2", "Blue", "blue" -> temp = new Mage(mageHead, 100, 5, false);
                case "Ranger", "ranger", "3", "Green", "green" -> temp = new Ranger(rangerHead, 100, 5, false);
                default -> System.out.println("Turning their marshmallows, the heroes waiting your call..");
            }
        }
        return temp;
    }

    public void part2(Player player) throws InterruptedException {
        // dialog continues
        br();
        System.out.println(player.getHero().getName());
        System.out.println("I'll take the lead. Our Master's missing, and we need to find out why.");
        br();
        narrator(PURPLE_ITALIC + "The trio decides to cover more ground, splitting up to search for clues." + player.getHero().getName() + PURPLE_ITALIC + " heads towards the waterfall alone." + RESET);
        br();
        assignFriendHeroes(player);
        br();
        System.out.println(player.getFriend1().getName());
        System.out.println("Me and " + player.getFriend2().getName() + " will scout ahead.");
        br();
        System.out.println(player.getFriend2().getName());
        System.out.println("Let's meet back here later, be careful.");
        br();
        narrator(PURPLE_ITALIC + "'" + player.getHero().getName() + PURPLE_ITALIC + " ventures into the forest alone.'" + RESET);
        br();
        br();
        sleep(3000);
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
