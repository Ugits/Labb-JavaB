package com.jonas.tales_of_descent_the_lost_senior.characters.monsters;
import com.jonas.tales_of_descent_the_lost_senior.interaction.ICombat;

public abstract class Monster implements ICombat {

    private String name;
    private int stamina;
    private int damage;
    private boolean dead;

    public Monster(String name, int stamina, int damage, boolean dead) {
        this.name = name;
        this.stamina = stamina;
        this.damage = damage;
        this.dead = dead;
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

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isDead() {
        return dead;
    }
    public void setDead(boolean dead) {
        this.dead = dead;
    }
}
