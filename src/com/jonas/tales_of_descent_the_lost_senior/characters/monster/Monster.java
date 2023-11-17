package com.jonas.tales_of_descent_the_lost_senior.characters.monster;

import com.jonas.tales_of_descent_the_lost_senior.characters.Character;

public abstract class Monster extends Character {

    public Monster(String name, int level, int staminaMax, int baseDamage, int strength, int intelligens, int dexterity, boolean dead) {
        super(
                RED_BOLD + name + RESET,
                level,
                staminaMax,
                strength,
                intelligens,
                dexterity,
                baseDamage,
                dead);
        setStaminaMax(getStaminaMax() + ((getLevel()-1) * 2));
        setStaminaCurrent(getStaminaMax());
        setDexterity(getDexterity() + ((getLevel()-1) * 2));
        setBaseDamage(getBaseDamage() + ((getLevel()-1) * 2));
    }

    @Override
    public String getLevelToStatus() {
        return RED_BOLD + " [" + getLevel() + "]" + RESET;
    }


}


