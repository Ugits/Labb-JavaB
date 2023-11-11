package com.jonas.tales_of_descent_the_lost_senior.characters;

import com.jonas.tales_of_descent_the_lost_senior.interaction.ICombat;

import static com.jonas.tales_of_descent_the_lost_senior.resources.IColors.*;
import static com.jonas.tales_of_descent_the_lost_senior.resources.IColors.RESET;

public abstract class Character {

    public int level;              // Utökar grund attributen: Styrka, intelligens och snabbhet

    public Character(int level) {
        this.level = level;
    }

    public StringBuilder staminaMeter(int stamina) {
        // TODO: 2023-11-09  make percentual 100 % stamina = full meter
        double expTemp = (double) stamina / 4;
        StringBuilder meter = new StringBuilder();

        meter.append(BLACK_BACKGROUND + BLACK_BOLD + "▐" + RESET);
        for (int i = 0; i < 25; i++) {
            if (expTemp > 0) {
                meter.append(BLACK_BACKGROUND + RED_BOLD + "█" + RESET);
                expTemp--;
            } else {
                meter.append(BLACK_BACKGROUND + WHITE_BOLD + "▒" + RESET);
            }
        }
        meter.append(BLACK_BACKGROUND + BLACK_BOLD + "▐" + RESET);

        return meter;
    }

    public String getLevelToStatus(){
        return  "         <Lvl " + getLevel() + ">";
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
