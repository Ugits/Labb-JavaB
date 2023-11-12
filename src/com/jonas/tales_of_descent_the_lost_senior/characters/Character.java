package com.jonas.tales_of_descent_the_lost_senior.characters;

import static com.jonas.tales_of_descent_the_lost_senior.resources.IColors.*;
import static com.jonas.tales_of_descent_the_lost_senior.resources.IColors.RESET;

public abstract class Character {
    public String name;
    public int staminaMax;
    public int staminaCurrent;
    public int level;              // Utökar grund attributen: Styrka, intelligens och snabbhet

    public Character(String name, int staminaMax, int level) {
        this.name = name;
        this.staminaMax = staminaMax;
        this.staminaCurrent = staminaMax;
        this.level = level;
    }


    public String staminaMeter(int staminaCurrent, int staminaMax) {

        double percentageOfMax = (double) staminaCurrent / staminaMax;

        int meterLength = 25;
        double percentageOfMeter = percentageOfMax * meterLength;

        StringBuilder meter = new StringBuilder();

        meter.append(BLACK_BACKGROUND + BLACK_BOLD + "▐" + RESET);
        for (int i = 0; i < meterLength; i++) {

            if (percentageOfMeter > 0) {
                meter.append(BLACK_BACKGROUND + RED_BOLD + "█" + RESET);
                percentageOfMeter--;

            } else {
                meter.append(BLACK_BACKGROUND + WHITE_BOLD + "▒" + RESET);
            }
        }
        meter.append(BLACK_BACKGROUND + BLACK_BOLD + "▐" + RESET);

        return meter.toString();
    }

    public String getLevelToStatus() {
        return "[ " + getLevel() + " ]";
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStaminaMax() {
        return staminaMax;
    }

    public void setStaminaMax(int staminaMax) {
        this.staminaMax = staminaMax;
    }

    public int getStaminaCurrent() {
        return staminaCurrent;
    }

    public void setStaminaCurrent(int staminaCurrent) {
        this.staminaCurrent = staminaCurrent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
