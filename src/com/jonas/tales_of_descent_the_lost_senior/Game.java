package com.jonas.tales_of_descent_the_lost_senior;

import com.jonas.tales_of_descent_the_lost_senior.enviorment.startingarea.TheThreeFriends;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.startingarea.Waterfall;
import com.jonas.tales_of_descent_the_lost_senior.objects.items.DungeonMap;
import com.jonas.tales_of_descent_the_lost_senior.objects.items.Item;
import com.jonas.tales_of_descent_the_lost_senior.objects.items.MysteryBox;
import com.jonas.tales_of_descent_the_lost_senior.player.Player;
import com.jonas.tales_of_descent_the_lost_senior.resources.CustomStrings;
import com.jonas.tales_of_descent_the_lost_senior.resources.InputProcessing;
import com.jonas.tales_of_descent_the_lost_senior.resources.OutputManipulation;

import java.util.Collections;
import java.util.Comparator;

public class Game {
    InputProcessing sc = new InputProcessing();
    OutputManipulation console = new OutputManipulation();
    Player player = new Player();

    public void run() throws InterruptedException {

        TheThreeFriends scene1 = new TheThreeFriends(player);
        Waterfall scene2 = new Waterfall(player);




        //loop

    }


}
