package com.jonas.tales_of_descent_the_lost_senior;

import com.jonas.tales_of_descent_the_lost_senior.characters.heroes.Knight;
import com.jonas.tales_of_descent_the_lost_senior.characters.heroes.Mage;
import com.jonas.tales_of_descent_the_lost_senior.characters.heroes.Ranger;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.dungeon.Dungeon;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.startingarea.IntoTheDark;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.startingarea.TheThreeFriends;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.startingarea.Waterfall;
import com.jonas.tales_of_descent_the_lost_senior.logic.GameLogic;
import com.jonas.tales_of_descent_the_lost_senior.player.Player;
import com.jonas.tales_of_descent_the_lost_senior.resources.InputProcessing;
import com.jonas.tales_of_descent_the_lost_senior.resources.OutputManipulation;

public class Game {

    InputProcessing sc = new InputProcessing();
    OutputManipulation console = new OutputManipulation();
    Player player = new Player();
    GameLogic logic = new GameLogic();

    public void run()  {

        //new TheThreeFriends(player);
        //new Waterfall(player);
        //new IntoTheDark(player);

        //loop
        //Dungeon map = new Dungeon(player);
        //map.getFloor().forEach(room -> logic.fight(room.getPlayer(), room.getMonster()));

        player.setHero(new Ranger());
        player.setFriend1(new Knight());
        player.setFriend2(new Mage());

        for (int floor = 1; floor <= 5; floor++) {

            Dungeon map = new Dungeon(player, floor);

            for (int room = 0; room < 5; room++) {

                map.getFloor().get(room).runScene();


            }

        }






        // TODO: 2023-11-05

        //map.getFloor().forEach(room -> System.out.println(room.getMonster().getName()));
        //map.getFloor().forEach(room -> System.out.println(room.isHasMonster()));
        //map.printMap();
    }

}
