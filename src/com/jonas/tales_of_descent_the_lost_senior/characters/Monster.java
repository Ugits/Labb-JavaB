package com.jonas.tales_of_descent_the_lost_senior.characters;

import com.jonas.tales_of_descent_the_lost_senior.interaction.ICombat;

public abstract class Monster extends Character {

    public Monster(String name, int level, int staminaMax, int baseDamage, int strength, int intelligens, int dexterity, boolean dead) {
        super(RED_BOLD + name + RESET, level, staminaMax, strength, intelligens, dexterity, baseDamage, dead);
    }

    @Override
    public String getLevelToStatus() {
        return RED_BOLD + " [" + getLevel() + "]" + RESET;
    }
}


