package com.jonas.tales_of_descent_the_lost_senior;

import com.jonas.tales_of_descent_the_lost_senior.characters.heroes.Hero;
import com.jonas.tales_of_descent_the_lost_senior.characters.heroes.Knight;
import com.jonas.tales_of_descent_the_lost_senior.characters.heroes.Mage;
import com.jonas.tales_of_descent_the_lost_senior.characters.heroes.Ranger;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.Scene;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.dungeon.Dungeon;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.startingarea.TheThreeFriends;
import com.jonas.tales_of_descent_the_lost_senior.resources.CustomStrings;
import com.jonas.tales_of_descent_the_lost_senior.resources.InputProcessing;

public class Game {

    Hero player = null;

    public void run() throws InterruptedException {

        InputProcessing sc = new InputProcessing();
        CustomStrings print = new CustomStrings();

        Scene scene1 = new TheThreeFriends();
        scene1.runScene();

        //player choose Character
        Hero player = null;
        while (player == null) {
            print.br();
            System.out.print("I will choose, The.. ");

            switch(sc.getScanner().nextLine()){
                case "Knight", "knight", "1", "Red", "red" -> player = new Knight();
                case "Mage", "mage", "2", "Blue", "blue" -> player = new Mage();
                case "Ranger", "ranger", "3", "Green", "green" -> player = new Ranger();
                default -> System.out.println("Turning their marshmallows, the heroes waiting your call. ");
            }
        }
        System.out.println(player.getClass());


        //loop

    }

}
