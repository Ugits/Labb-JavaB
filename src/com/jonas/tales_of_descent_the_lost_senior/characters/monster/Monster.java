package com.jonas.tales_of_descent_the_lost_senior.characters.monster;

import com.jonas.tales_of_descent_the_lost_senior.Game;
import com.jonas.tales_of_descent_the_lost_senior.characters.Character;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.dungeon.Room;
import com.jonas.tales_of_descent_the_lost_senior.interaction.DiceSet;

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
                0,
                dead);
        setStaminaMax(getStaminaMax() + ((getLevel() - 1) * 5));
        setStaminaCurrent(getStaminaMax());
        setDexterity(getDexterity() + ((getLevel() - 1) * 2));
        setBaseDamage(getBaseDamage() + ((getLevel() - 1) * 3));
    }

    @Override
    public String getLevelToStatus() {
        return RED_BOLD + " [" + getLevel() + "]" + RESET;
    }


    @Override
    public void attack(Character character, Game game) {

    }

    @Override
    public void advancedAttack() {

    }

    @Override
    public void flee(Room room, Game game) {

    }

    @Override
    public void parry() {

    }

    @Override
    public void dies(Game game) {

    }
}


