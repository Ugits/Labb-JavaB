package com.jonas.tales_of_descent_the_lost_senior.characters;

import com.jonas.tales_of_descent_the_lost_senior.interaction.DiceSet;
import com.jonas.tales_of_descent_the_lost_senior.interaction.ICombat;
import com.jonas.tales_of_descent_the_lost_senior.logic.CombatLogic;
import com.jonas.tales_of_descent_the_lost_senior.objects.Item;
import com.jonas.tales_of_descent_the_lost_senior.resources.IColors;
import com.jonas.tales_of_descent_the_lost_senior.resources.OutputManipulation;

import java.util.HashMap;
import java.util.List;

public abstract class Character extends CombatLogic implements ICombat, IColors {
    OutputManipulation out = new OutputManipulation();

    private String name;
    private int level;
    private int staminaMax;
    private int staminaCurrent;
    private int strength;
    private int intelligence;
    private int dexterity;
    private int baseDamage;
    private int luck;
    private boolean dead;

    public Character(String name, int level, int staminaMax, int strength, int intelligence, int dexterity, int baseDamage,int luck, boolean dead) {
        setName(name);
        setLevel(level);
        setStaminaMax(staminaMax);
        setStaminaCurrent(staminaMax);
        setStrength(strength);
        setIntelligence(intelligence);
        setDexterity(dexterity);
        setBaseDamage(baseDamage);
        setLuck(0);
        setDead(dead);
    }

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

    public void takeDamage(int amount) {
        setStaminaCurrent(getStaminaCurrent() - amount);
    }
    public int calculateDamage() {
        DiceSet roll = new DiceSet();
        return getLevel() + roll.dCustom(getBaseDamage());
    }

    // for HERO-- cant reach if I declare in Hero class

    public int getMainAttribute() {return 0;}
    public void setMainAttribute(int newValue) {}
    public boolean isFleeing() {
        return false;
    }

    public void setFleeing(boolean fleeing) {
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public void lootMonster() {
    }

    public void gainExp(int monsterLevel) {
    }
    public int getRevives() {
        return 0;
    }
    public void setRevives(int revives) {
    }
    public void revive() {
    }
    public int getCoins() {
        return 0;
    }
    public void setCoins(int coins) {
    }

    // Heroes inventory
    public void printInventoryHash() {
    }
    public Item getItem(String item){
        return getInventoryHash().get(item);
    }
    public int printInventoryHashOwned() {
        return 0;
    }
    public int printStore() {
        return 0;
    }



/**
 *
     // Heroes Inventory
     public void initInventory() {
     }
     public void printOwnedItems() {
     }
     public void printNotOwnedItems() {
     }
     public void pickUpItem(String stringItem) {
     }
     public void printInventory() {
     }
     public void sortPrioOwnedItems() {
     }
     public void sortPrioNotOwnedItems() {
     }



 */



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

    public boolean isAttacking() {
        return false;
    }
    public void setAttacking(boolean attacking) {
    }
    public void setFirstTimeInDungeon(boolean b) {
    }
    public boolean isFirstTimeInDungeon() {
        return false;
    }
    public void getStatus() {
    }
    public List<Item> getInventory() {
        return null;
    }
    public HashMap<String, Item> getInventoryHash() {
        return null;
    }

    public int getExperience() {
        return 0;
    }

    public void setExperience(int experience) {
    }


}
