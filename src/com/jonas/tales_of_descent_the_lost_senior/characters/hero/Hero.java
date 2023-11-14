package com.jonas.tales_of_descent_the_lost_senior.characters.hero;

import com.jonas.tales_of_descent_the_lost_senior.characters.Character;
import com.jonas.tales_of_descent_the_lost_senior.interaction.DiceSet;
import com.jonas.tales_of_descent_the_lost_senior.objects.Item;
import com.jonas.tales_of_descent_the_lost_senior.objects.items.DungeonMap;
import com.jonas.tales_of_descent_the_lost_senior.objects.items.MysteryBox;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;


public abstract class Hero extends Character implements IStaminaConsumption {

    private int luck;
    private int experience;
    private boolean firstTimeInDungeon;
    List<Item> inventory = new ArrayList<>();

    public Hero(String name, int level, int staminaMax, int baseDamage, int strength, int intelligens, int dexterity, boolean dead) {
        super(name, level, staminaMax, strength, intelligens, dexterity,baseDamage, dead);
        this.experience = 0;
        this.luck = 0;
        this.firstTimeInDungeon = true;
        initInventory();
    }

    //Implements IStaminaConsumption
    @Override
    public void consumeStamina(int staAmount) {
        setStaminaCurrent(getStaminaCurrent() - staAmount);
    }


    // Implements IInventory
    @Override
    public void initInventory() {
        inventory.add(new MysteryBox());
        inventory.add(new DungeonMap());
    }

    @Override
    public void printOwnedItems() {
        sortPrioOwnedItems();
        int index = 1;
        for (Item item : getInventory()) {
            if (item.isOwned()) {
                System.out.println(index + ". " + item.getName());
                index++;
            }
        }
    }

    @Override
    public void printNotOwnedItems() {
        sortPrioNotOwnedItems();
        int index = 1;
        for (Item item : getInventory()) {
            if (!item.isOwned()) {
                System.out.println(index + ". " + item.getName());
                index++;
            }
        }
    }

    @Override
    public void pickUpItem(String stringItem) {
        getInventory().forEach(item -> {
            if (Objects.equals(item.getName(), stringItem)) {
                item.setOwned(true);
            }
        });
    }

    @Override
    public void printInventory() {
        getInventory().forEach(item -> System.out.println(item.getName() + " " + item.isOwned()));
    }

    @Override
    public void sortPrioOwnedItems() {
        getInventory().sort(Comparator.comparing(Item::isOwned).reversed());
    }

    @Override
    public void sortPrioNotOwnedItems() {
        getInventory().sort(Comparator.comparing(Item::isOwned));
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

    @Override
    public void gainExp(int monsterLevel) {
        System.out.println("gained " + ((10 * monsterLevel)/2) +" + "+ ((25 / getLevel())/2) + " XP");
        setExperience(getExperience() + ((10 * monsterLevel) + (25 / getLevel())));
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

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }
}
