package com.jonas.tales_of_descent_the_lost_senior.characters;
import com.jonas.tales_of_descent_the_lost_senior.characters.Character;
import com.jonas.tales_of_descent_the_lost_senior.interaction.ICombat;

public abstract class Monster extends Character implements ICombat {

    int baseDamage;

    public Monster(String name, int level, int staminaMax, int baseDamage, int strength, int intelligens, int dexterity, boolean dead) {
        super(RED_BOLD + name + RESET, level, staminaMax, strength, intelligens, dexterity, dead);
        this.baseDamage = baseDamage;
    }


    @Override
    public void attack() {
        System.out.println("Monster attack");
    }

    @Override
    public void advancedAttack() {
        System.out.println("Monster advanced attack");
    }

    @Override
    public void flee() {
        System.out.println("Monster flee");
    }

    @Override
    public void parry() {
        System.out.println("Monster parry");
    }

    @Override
    public String getLevelToStatus() {
        return RED_BOLD +" [" + getLevel() + "]" + RESET;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public int calculateDamage() {
        return getBaseDamage();
    }
    public void checkIfDead(){
        if (isDead()){

        }
    }
}
