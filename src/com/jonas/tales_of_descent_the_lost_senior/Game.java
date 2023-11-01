package com.jonas.tales_of_descent_the_lost_senior;

import com.jonas.tales_of_descent_the_lost_senior.enviorment.startingarea.TheThreeFriends;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.startingarea.Waterfall;
import com.jonas.tales_of_descent_the_lost_senior.player.Player;
import com.jonas.tales_of_descent_the_lost_senior.resources.CustomStrings;
import com.jonas.tales_of_descent_the_lost_senior.resources.InputProcessing;

public class Game {
    InputProcessing sc = new InputProcessing();
    CustomStrings print = new CustomStrings();
    Player player = new Player();

    public void run() throws InterruptedException {


        TheThreeFriends scene1 = new TheThreeFriends(player);
        Waterfall scene2 = new Waterfall(player);




        //loop

    }


}
