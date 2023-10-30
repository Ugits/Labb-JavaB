package com.jonas.tales_of_descent_the_lost_senior.enviorment;

import com.jonas.tales_of_descent_the_lost_senior.resources.CustomStrings;

public abstract class Scene extends CustomStrings {
    String description;
    int visibility = 10;
    int breathability = 10;

    public Scene(int visibilityMod, int breathabilityMod) {
        this.visibility += visibilityMod;
        this.breathability += breathabilityMod;
    }

    // TODO: 2023-10-24  can a interface variable be manipulated. is it final??!!
    // TODO: 2023-10-24 alternatively, make abstract class. with method to manipulate values with internal methods!!!!!!

    public void runScene() throws InterruptedException {
        println(sceneHead);
        Thread.sleep(1000);
        System.out.println("this is a scene");
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
}
