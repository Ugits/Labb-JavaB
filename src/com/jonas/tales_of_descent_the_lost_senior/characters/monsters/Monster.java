package com.jonas.tales_of_descent_the_lost_senior.characters.monsters;
import com.jonas.tales_of_descent_the_lost_senior.characters.Character;
import com.jonas.tales_of_descent_the_lost_senior.interaction.ICombat;

import static com.jonas.tales_of_descent_the_lost_senior.resources.IColors.*;

public abstract class Monster extends Character implements ICombat {


    private int baseDmg;
    private boolean dead;

    public Monster(String name, int stamina, int damage, boolean dead, int level) {
        super(
                RED_BOLD + name + RESET,
                stamina,
                level);


        this.baseDmg = damage;
        this.dead = dead;
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

    public int getBaseDmg() {
        return baseDmg;
    }
    public void setBaseDmg(int baseDmg) {
        this.baseDmg = baseDmg;
    }

    public boolean isDead() {
        return dead;
    }
    public void setDead(boolean dead) {
        this.dead = dead;
    }
}
