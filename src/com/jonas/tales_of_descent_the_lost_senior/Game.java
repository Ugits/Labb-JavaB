package com.jonas.tales_of_descent_the_lost_senior;

import com.jonas.tales_of_descent_the_lost_senior.characters.hero.models.Knight;
import com.jonas.tales_of_descent_the_lost_senior.characters.hero.models.Mage;
import com.jonas.tales_of_descent_the_lost_senior.characters.hero.models.Ranger;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.dungeon.Dungeon;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.startingarea.IntoTheDark;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.startingarea.TheThreeFriends;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.startingarea.Waterfall;
import com.jonas.tales_of_descent_the_lost_senior.logic.GameLogic;
import com.jonas.tales_of_descent_the_lost_senior.objects.Item;
import com.jonas.tales_of_descent_the_lost_senior.objects.items.DungeonMap;
import com.jonas.tales_of_descent_the_lost_senior.objects.items.MysteryBox;
import com.jonas.tales_of_descent_the_lost_senior.player.Player;
import com.jonas.tales_of_descent_the_lost_senior.resources.InputProcessing;
import com.jonas.tales_of_descent_the_lost_senior.resources.MenuTool;
import com.jonas.tales_of_descent_the_lost_senior.resources.OutputManipulation;

import java.util.Objects;

public class Game {

    /**
     * InputProcessing sc = new InputProcessing();
     * OutputManipulation console = new OutputManipulation();
     */
    Player player = new Player();
    private int floorIndex = 0;
    private int roomIndex = 0;
    private Dungeon map;

    public void run() {

        //new TheThreeFriends(player);
        //new Waterfall(player);
        //new IntoTheDark(player);

        player.setHero(new Ranger());
        player.setFriend1(new Knight());
        player.setFriend2(new Mage());
        //GameLogic logic = new GameLogic();


        //MenuTool menu = new MenuTool(roomIndex,floorIndex);
        for (floorIndex = 1; floorIndex <= 5; floorIndex++) {

            map = new Dungeon(player.getHero(), floorIndex, this);

            map.printMap();
            for (roomIndex = 0; roomIndex < 5; roomIndex++) {

                map.getHero().printInventoryHash();

                map.getFloor().get(roomIndex).runScene();
                map.getFloor().get(roomIndex).checkIfMonster();
                map.getFloor().get(roomIndex).runHeroAction();

            }
        }
        // TODO: 2023-11-05

        //map.getFloor().forEach(room -> System.out.println(room.getMonster().getName()));
        //map.getFloor().forEach(room -> System.out.println(room.isHasMonster()));
        //map.printMap();
    }

    public int getFloorIndex() {
        return floorIndex;
    }

    public void setFloorIndex(int floorIndex) {
        this.floorIndex = floorIndex;
    }

    public int getRoomIndex() {
        return roomIndex;
    }

    public void setRoomIndex(int roomIndex) {
        this.roomIndex = roomIndex;
    }

    public Dungeon getMap() {
        return map;
    }

    public void setMap(Dungeon map) {
        this.map = map;
    }
}
