package com.jonas.tales_of_descent_the_lost_senior.enviorment;

public abstract class Atmosphere {

    int visibility = 10;
    int breathability = 10;

    public Atmosphere(int visibilityMod, int breathabilityMod) {
        this.visibility += visibilityMod;
        this.breathability += breathabilityMod;
    }

    // TODO: 2023-10-24  can a interface variable be manipulated. is it final??


    // TODO: 2023-10-24 alternatively, make abstract class. with method to manipulate values with internal methods


    public int getVisibility() {
        return visibility;
    }

    public int getBreathability() {
        return breathability;
    }
}
