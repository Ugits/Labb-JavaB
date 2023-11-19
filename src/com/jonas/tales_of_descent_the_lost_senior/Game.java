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

    private Player player = new Player();
    private int floorIndex = 0;
    private int roomIndex = 0;
    private Dungeon map;
    private boolean gameOver;
    private boolean gameOn;

    public Game() {

    }

    public void newGame(){
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


        do {

            while (!getPlayer().getHero().isDead()) {

                for (setFloorIndex(1); getFloorIndex() <= 5; setFloorIndex(getFloorIndex()+1)) {
                    if (getPlayer().getHero().isDead() && getPlayer().getHero().getRevives() <= 0) {

                        getOut().printNarrative("This time," + getPlayer().getHero().getName() + " wont wake up..");
                        setGameOver(true);
                        break;

                    } else if (getPlayer().getHero().isDead() && getPlayer().getHero().getRevives() > 0) {

                        getPlayer().getHero().revive();

                    }

                    setMap(new Dungeon(getPlayer().getHero(), getFloorIndex(), this));

                    for (setRoomIndex(0); getRoomIndex() < 5; setRoomIndex(getRoomIndex()+1)) {
                        getPlayer().getHero().setFleeing(false);
                        if (getPlayer().getHero().getItem("Lucky Dice Set").isOwned()) {
                            getPlayer().getHero().setLuck(2);
                            //System.out.println("luck = 2     [ DEBUG ]");
                        }
                        //map.getHero().printInventoryHash();
                        getMap().getFloor().get(getRoomIndex()).runScene();
                        getMap().getFloor().get(getRoomIndex()).checkIfMonster();

                        if (!getPlayer().getHero().isDead() && !getPlayer().getHero().isFleeing()) {
                            getMap().getFloor().get(getRoomIndex()).runHeroAction();
                        }

                        if (getPlayer().getHero().isDead()){
                            setFloorIndex(0);
                            setRoomIndex(0);
                            break;
                        }

                    }
                    getOut().printNarrative("After wandering a while in the dungeon caves, you now see the light.");
                    getOut().printNarrative("could it be?.. ");
                    getOut().sleep(3);
                    getOut().printNarrative("To be continued ;) ");
                    break;

                }
            }

        } while (!isGameOver());
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
