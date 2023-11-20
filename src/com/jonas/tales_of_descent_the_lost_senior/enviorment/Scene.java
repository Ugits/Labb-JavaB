package com.jonas.tales_of_descent_the_lost_senior.enviorment;

import com.jonas.tales_of_descent_the_lost_senior.Game;
import com.jonas.tales_of_descent_the_lost_senior.player.Player;
import com.jonas.tales_of_descent_the_lost_senior.resources.IColors;
import com.jonas.tales_of_descent_the_lost_senior.resources.InputProcessing;
import com.jonas.tales_of_descent_the_lost_senior.resources.OutputManipulation;

public abstract class Scene implements IColors{
    OutputManipulation out = new OutputManipulation();
    InputProcessing sc = new InputProcessing();

    private Game game;
    private String description;


    public Scene(Game game) {
        this.game = game;

    }

    public Scene() {
        //setDescription(description);
    }

    // TODO: 2023-10-24  can a interface variable be manipulated. is it final??!!
    // TODO: 2023-10-24 alternatively, make abstract class. with method to manipulate values with internal methods!!!!!!

    public void runScene() {
        System.out.println(getOut().sceneHead);
        getOut().sleep(1000);
        System.out.println("this is a scene");
    }

    public void description(){
        getOut().printScene(description);
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public OutputManipulation getOut() {
        return out;
    }

    public void setOut(OutputManipulation out) {
        this.out = out;
    }


    public InputProcessing getSc() {
        return sc;
    }

    public void setSc(InputProcessing sc) {
        this.sc = sc;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
