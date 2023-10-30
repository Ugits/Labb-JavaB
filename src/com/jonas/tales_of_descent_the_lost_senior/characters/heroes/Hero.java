package com.jonas.tales_of_descent_the_lost_senior.characters.heroes;

import com.jonas.tales_of_descent_the_lost_senior.interaction.ICombat;
import com.jonas.tales_of_descent_the_lost_senior.resources.CustomStrings;

public abstract class Hero implements ICombat {

    private String name;
    private int stamina;
    private int baseDmg;
    private boolean dead;

    public Hero(String name, int stamina, int baseDmg, boolean dead) {
        this.name = name;
        this.stamina = stamina;
        this.baseDmg = baseDmg;
        this.dead = dead;
    }

    @Override
    public void attack() {
        System.out.println("Hero attack");
    }

    @Override
    public void advancedAttack() {
        System.out.println("Hero Advanced attack");
    }

    @Override
    public void flee() {
        System.out.println("Hero fled");
    }

    @Override
    public void parry() {
        System.out.println("Hero parry's");
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getStamina() {
        return stamina;
    }
    public void setStamina(int stamina) {
        this.stamina = stamina;
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
