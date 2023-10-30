package com.jonas.tales_of_descent_the_lost_senior.characters.monsters;
import com.jonas.tales_of_descent_the_lost_senior.interaction.ICombat;

public abstract class Monster implements ICombat {

    private String name;
    private int stamina;
    private int baseDmg;
    private boolean dead;

    public Monster(String name, int stamina, int damage, boolean dead) {
        this.name = name;
        this.stamina = stamina;
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
