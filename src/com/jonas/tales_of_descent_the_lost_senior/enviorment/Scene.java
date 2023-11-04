package com.jonas.tales_of_descent_the_lost_senior.enviorment;

import com.jonas.tales_of_descent_the_lost_senior.player.Player;
import com.jonas.tales_of_descent_the_lost_senior.resources.CustomStrings;
import com.jonas.tales_of_descent_the_lost_senior.resources.InputProcessing;
import com.jonas.tales_of_descent_the_lost_senior.resources.OutputManipulation;

public abstract class Scene extends CustomStrings {
    InputProcessing sc = new InputProcessing();
    OutputManipulation console = new OutputManipulation();
    Player player;
    String description;
    int visibility = 10;
    int breathability = 10;

    public Scene(Player player,int visibilityMod, int breathabilityMod, String description) {
        setPlayer(player);
        setVisibility(visibilityMod);
        setBreathability(breathabilityMod);
        setDescription(description);
    }

    // TODO: 2023-10-24  can a interface variable be manipulated. is it final??!!
    // TODO: 2023-10-24 alternatively, make abstract class. with method to manipulate values with internal methods!!!!!!

    public void runScene() throws InterruptedException {
        System.out.println(sceneHead);
        Thread.sleep(1000);
        System.out.println("this is a scene");
    }

    public void description() throws InterruptedException {
        console.printScene(description);
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVisibility() {
        return visibility;
    }

    public int getBreathability() {
        return breathability;
    }

    public OutputManipulation getConsole() {
        return console;
    }

    public void setConsole(OutputManipulation console) {
        this.console = console;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public void setBreathability(int breathability) {
        this.breathability = breathability;
    }

    public InputProcessing getSc() {
        return sc;
    }

    public void setSc(InputProcessing sc) {
        this.sc = sc;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
