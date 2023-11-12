package com.jonas.tales_of_descent_the_lost_senior.characters;

import com.jonas.tales_of_descent_the_lost_senior.interaction.DiceSet;


public abstract class Hero extends Character {

    private int luck;
    private int experience;
    private boolean firstTimeInDungeon;

    public Hero(String name, int level, int staminaMax, int baseDamage, int strength, int intelligens, int dexterity, boolean dead) {
        super(name, level, staminaMax, strength, intelligens, dexterity,baseDamage, dead);
        this.experience = 0;
        this.luck = 0;
        this.firstTimeInDungeon = true;

    }
    //Hero methods
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

    public void getStatus() {
        System.out.println(getName() + getLevelToStatus());
        System.out.println("XP : " + xpMeter(getExperience()));
        System.out.println("STA: " + staminaMeter(getStaminaCurrent(), getStaminaMax()));
        System.out.println("STR: " + getStrength());
        System.out.println("INT: " + getIntelligence());
        System.out.println("DEX: " + getDexterity());
        System.out.println("DMG: " + getBaseDamage());
    }
    public int getMainAttribute() {
        return 0;
    }

    public int calculateDamage() {
        DiceSet roll = new DiceSet();
        //int mainAttMod = getMainAttribute() / 2;
        //int test = roll.dCustom(mainAttMod);
        //System.out.print(test);
        //System.out.println(" Roll [CALCULATE]");
        //System.out.println(mainAttMod + "  Main ATT Mod [CALCULATE]");
        //System.out.print(test + mainAttMod);
        //System.out.println("  Total [CALCULATE]");
        return getBaseDamage() + roll.dCustom(getMainAttribute() / 2);
    }





    // GET n SET
    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public boolean isFirstTimeInDungeon() {
        return firstTimeInDungeon;
    }

    public void setFirstTimeInDungeon(boolean firstTimeInDungeon) {
        this.firstTimeInDungeon = firstTimeInDungeon;
    }






}
