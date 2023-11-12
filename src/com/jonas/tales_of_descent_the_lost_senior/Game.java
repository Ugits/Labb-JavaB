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

        player.setHero(new Ranger(console.rangerHead));
        player.setFriend1(new Knight(console.knightHead));
        player.setFriend2(new Mage(console.mageHead));

        Dungeon map = new Dungeon(player, 1);

        map.getFloor().get(0).runScene();
        map.getFloor().get(1).runScene();
        map.getFloor().get(2).runScene();
        map.getFloor().get(3).runScene();
        map.getFloor().get(4).runScene();


        // TODO: 2023-11-05

        //map.getFloor().forEach(room -> System.out.println(room.getMonster().getName()));
        //map.getFloor().forEach(room -> System.out.println(room.isHasMonster()));
        //map.printMap();
    }

}
