package com.jonas.tales_of_descent_the_lost_senior.characters.monsters;

public class PackOfRats extends Monster {

    public String name = "Pack of Rats";
    public int stamina = 5;
    public int damage = 1;
    public boolean dead = false;

    public PackOfRats() {
       setName(this.name);
       setStamina(this.stamina);
       setDamage(this.damage);
       setDead(this.dead);
    }

    @Override
    public void attack() {
        System.out.println("A rat jumps your leg, and bite!");
        //damage player
    }

    @Override
    public void advancedAttack() {
        System.out.println("The pack surrounds you, biting and scratching!");
        //damage player
    }

    @Override
    public void flee() {
        System.out.println("They run away. The rats seams frightened by something,");
    }

    @Override
    public void parry() {

    }

}
