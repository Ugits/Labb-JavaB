package com.jonas.tales_of_descent_the_lost_senior.characters.heroes;

import com.jonas.tales_of_descent_the_lost_senior.characters.Character;
import com.jonas.tales_of_descent_the_lost_senior.interaction.ICombat;
import com.jonas.tales_of_descent_the_lost_senior.resources.OutputManipulation;

import static com.jonas.tales_of_descent_the_lost_senior.resources.IColors.*;

public abstract class Hero extends Character implements ICombat {
    OutputManipulation console = new OutputManipulation();


    int strength;           // Styrka
    int intelligence;       // Intelligens
    int dexterity;          // Skicklighet/Snabbhet/Vighet
    int experience;         // Poäng till nästa nivå
    private int baseDmg;    // Grund skada
    private boolean dead;   // is dead?
    private boolean firstTimeInDungeon = true;

    public Hero(String name, int strength, int intelligence, int dexterity, int stamina, int experience, int level, int baseDmg, boolean dead) {
        super(
                name,
                stamina,
                level);


        this.strength = strength;
        this.intelligence = intelligence;
        this.dexterity = dexterity;
        this.experience = experience;
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






    public void getStatus() {
        System.out.println(getName() + getLevelToStatus());
        System.out.println("XP : " + xpMeter(getExperience()));
        System.out.println("STA: " + staminaMeter(getStaminaCurrent(),getStaminaMax()));
        System.out.println("STR: " + getStrength());
        System.out.println("INT: " + getIntelligence());
        System.out.println("DEX: " + getDexterity());
        System.out.println("DMG: " + getBaseDmg());
    }

    private StringBuilder xpMeter(int exp) {

        double expTemp = (double) exp / 4;
        StringBuilder meter = new StringBuilder();

        meter.append(BLACK_BACKGROUND + BLACK_BOLD + "▐" + RESET);
        for (int i = 0; i < 25; i++) {
            if (expTemp > 0) {
                meter.append(BLACK_BACKGROUND + GREEN_BOLD + "█" + RESET);
                expTemp--;
            } else {
                meter.append(BLACK_BACKGROUND + WHITE_BOLD + "▒" + RESET);
            }
        }
        meter.append(BLACK_BACKGROUND + BLACK_BOLD + "▐" + RESET);

        return meter;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
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

    public boolean isFirstTimeInDungeon() {
        return firstTimeInDungeon;
    }

    public void setFirstTimeInDungeon(boolean firstTimeInDungeon) {
        this.firstTimeInDungeon = firstTimeInDungeon;
    }
}
