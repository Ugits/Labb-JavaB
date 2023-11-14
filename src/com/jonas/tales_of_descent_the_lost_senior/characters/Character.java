package com.jonas.tales_of_descent_the_lost_senior.characters;
import com.jonas.tales_of_descent_the_lost_senior.interaction.DiceSet;
import com.jonas.tales_of_descent_the_lost_senior.interaction.ICombat;
import com.jonas.tales_of_descent_the_lost_senior.logic.GameLogic;
import com.jonas.tales_of_descent_the_lost_senior.resources.IColors;
import com.jonas.tales_of_descent_the_lost_senior.resources.OutputManipulation;

public abstract class Character extends GameLogic implements ICombat, IColors {
    OutputManipulation out = new OutputManipulation();

    private String name;
    private int level;              // Utökar grund attributen: Styrka, intelligens och snabbhet
    private int staminaMax;
    private int staminaCurrent;
    private int strength;           // Styrka // + Dmg
    private int intelligence;       // Intelligens // for casting intelligence
    private int dexterity;          // Skicklighet/Snabbhet/Vighet // hit chance/ dodge  DEX vs DEX
    private int baseDamage;
    private boolean dead;

    public Character(String name, int level, int staminaMax, int strength, int intelligence, int dexterity,int baseDamage, boolean dead) {
        setName(name);
        setLevel(level);
        setStaminaMax(staminaMax);
        setStaminaCurrent(staminaMax);
        setStrength(strength);
        setIntelligence(intelligence);
        setDexterity(dexterity);
        setBaseDamage(baseDamage);
        setDead(dead);
    }

    /**
     * public void consumeStamina(int amount) {
         setStaminaCurrent(getStaminaCurrent() - amount);
     }
     */

    public String staminaMeter(int staminaCurrent, int staminaMax) {

        double percentageOfMax = (double) staminaCurrent / staminaMax;

        int meterLength = 25;
        double percentageOfMeter = percentageOfMax * meterLength;

        StringBuilder meter = new StringBuilder();

        meter.append(BLACK_BACKGROUND + BLACK_BOLD + "▐" + RESET);
        for (int i = 0; i < meterLength; i++) {

            if (percentageOfMeter > 0) {
                meter.append(BLACK_BACKGROUND + RED_BOLD + "█" + RESET);
                percentageOfMeter--;

            } else {
                meter.append(BLACK_BACKGROUND + WHITE_BOLD + "▒" + RESET);
            }
        }
        meter.append(BLACK_BACKGROUND + BLACK_BOLD + "▐" + RESET);

        return meter.toString();
    }

    public String getLevelToStatus() {
        return "[ " + getLevel() + " ]";
    }

    public void takeDamage(int amount){
        setStaminaCurrent(getStaminaCurrent() - amount);
    }

    public int calculateDamage(){
        DiceSet roll = new DiceSet();
        return roll.dCustom(getBaseDamage());
    }






    // Implements IInventory
    public void initInventory(){};
    public void printOwnedItems(){};
    public void printNotOwnedItems(){};
    public void pickUpItem(String stringItem){};
    public void printInventory(){};
    public void sortPrioOwnedItems(){};
    public void sortPrioNotOwnedItems(){};
    public boolean isFirstTimeInDungeon() {
        return false;
    }
    public void setFirstTimeInDungeon(boolean b) {}




    // GET n SET
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    public int getStaminaMax() {
        return staminaMax;
    }
    public void setStaminaMax(int staminaMax) {
        this.staminaMax = staminaMax;
    }

    public int getStaminaCurrent() {
        return staminaCurrent;
    }
    public void setStaminaCurrent(int staminaCurrent) {
        this.staminaCurrent = staminaCurrent;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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

    public boolean isDead() {
        return dead;
    }
    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public int getBaseDamage() {
        return baseDamage;
    }
    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public OutputManipulation getOut() {
        return out;
    }
    public void setOut(OutputManipulation out) {
        this.out = out;
    }
    public void getStatus() {}


    public void gainExp(int monsterLevel) {}
}
