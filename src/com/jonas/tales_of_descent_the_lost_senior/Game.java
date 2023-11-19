package com.jonas.tales_of_descent_the_lost_senior;

import com.jonas.tales_of_descent_the_lost_senior.characters.hero.models.Knight;
import com.jonas.tales_of_descent_the_lost_senior.characters.hero.models.Mage;
import com.jonas.tales_of_descent_the_lost_senior.characters.hero.models.Ranger;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.dungeon.Dungeon;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.startingarea.IntoTheDark;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.startingarea.TheThreeFriends;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.startingarea.Waterfall;
import com.jonas.tales_of_descent_the_lost_senior.player.Player;
import com.jonas.tales_of_descent_the_lost_senior.resources.InputProcessing;
import com.jonas.tales_of_descent_the_lost_senior.resources.OutputManipulation;

public class Game {


    InputProcessing sc = new InputProcessing();
    OutputManipulation out = new OutputManipulation();

    Player player = new Player();
    private int floorIndex = 0;
    private int roomIndex = 0;
    private Dungeon map;
    boolean gameOver;
    boolean gameOn;

    public Game() {
        do {

            run();
            playAgain();

        } while (isGameOn());
        System.out.println("GAME OVER");
    }

    public void run() {

        new TheThreeFriends(this);
        new Waterfall(this);
        new IntoTheDark(this);

        //player.setHero(new Ranger());
        //player.setFriend1(new Knight());
        //player.setFriend2(new Mage());

        //player.getHero().getItem("Mystery Box").use(this);

        do {

            while (!player.getHero().isDead()) {

                for (floorIndex = 1; floorIndex <= 5; floorIndex++) {
                    if (player.getHero().isDead() && player.getHero().getRevives() <= 0) {
                        //End loop
                        getOut().printNarrative("This time," + player.getHero().getName() + " wont wake up..");
                        gameOver = true;
                        break;
                    } else if (player.getHero().isDead() && player.getHero().getRevives() > 0) {

                        player.getHero().revive();

                    }

                    setMap(new Dungeon(player.getHero(), floorIndex, this));

                    for (roomIndex = 0; roomIndex < 5; roomIndex++) {

                        //map.getHero().printInventoryHash();
                        map.getFloor().get(roomIndex).runScene();
                        map.getFloor().get(roomIndex).checkIfMonster();

                        if (!player.getHero().isDead()) {
                            map.getFloor().get(roomIndex).runHeroAction();
                        } else {
                            floorIndex = 0;
                            roomIndex = 0;
                            break;
                        }
                    }
                }
            }

        } while (!gameOver);
        System.out.println("Will we ever get to know what happened to our master\n");

    }

    public void playAgain() {
        System.out.println("Do you wish to play again?  [Y / N]");
        String choice = getSc().nextAlphabeticalLine();
        switch (choice.toLowerCase()) {
            case "y", "yes" -> setGameOn(true);
            case "n", "no" -> setGameOn(false);
        }
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

    public InputProcessing getSc() {
        return sc;
    }

    public void setSc(InputProcessing sc) {
        this.sc = sc;
    }

    public OutputManipulation getOut() {
        return out;
    }

    public void setOut(OutputManipulation out) {
        this.out = out;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isGameOn() {
        return gameOn;
    }

    public void setGameOn(boolean gameOn) {
        this.gameOn = gameOn;
    }
}
