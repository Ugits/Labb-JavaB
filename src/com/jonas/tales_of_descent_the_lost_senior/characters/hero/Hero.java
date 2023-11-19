package com.jonas.tales_of_descent_the_lost_senior.characters.hero;

import com.jonas.tales_of_descent_the_lost_senior.Game;
import com.jonas.tales_of_descent_the_lost_senior.characters.Character;
import com.jonas.tales_of_descent_the_lost_senior.interaction.DiceSet;
import com.jonas.tales_of_descent_the_lost_senior.objects.Item;
import com.jonas.tales_of_descent_the_lost_senior.objects.items.DungeonMap;
import com.jonas.tales_of_descent_the_lost_senior.objects.items.MysteryBox;

import java.util.*;

public abstract class Hero extends Character {

    int coins;
    int revives;
    private int luck;
    private int experience;
    private boolean firstTimeInDungeon;
    private List<Item> inventory = new ArrayList<>();
    public HashMap<String, Item> inventoryHash = new HashMap<>();
    private boolean attacking;
    int itemNum = 0;


    public Hero(String name, int level, int staminaMax, int baseDamage, int strength, int intelligens, int dexterity, boolean dead) {
        super(name, level, staminaMax, strength, intelligens, dexterity, baseDamage, dead);
        this.experience = 0;
        this.luck = 0;
        this.firstTimeInDungeon = true;
        this.attacking = true;
        this.revives = 2;
        //initInventory();
        initInventoryHash();
    }

    // gain xp definition
    public void gainExp(int monsterLevel) {
        int xpPerMob = 25;
        if (monsterLevel >= getLevel()) {
            // 100 ‰ XP of (xp/mob (25?))
            //System.out.println("monster lvl: " + monsterLevel+ " will grant " + xpPerMob + " XP to Player lvl: " + playerLevel );
            getOut().println(YELLOW_ITALIC + "+" + xpPerMob + " xp" + RESET);
            setExperience(getExperience() + xpPerMob);
        } else if (monsterLevel == (getLevel() - 1)) {
            // 50 % xp
            //System.out.println("monster lvl: " + monsterLevel + " will grant " + xpPerMob * 0.5 + " XP to Player lvl: " + playerLevel);
            getOut().println(YELLOW_ITALIC + "+" + (int) (xpPerMob * 0.5) + " xp" + RESET);
            setExperience(getExperience() + (int) (xpPerMob * 0.5));
        } else if (monsterLevel == (getLevel() - 2)) {
            // 20 % xp
            //System.out.println("monster lvl: " + monsterLevel + " will grant " + xpPerMob * 0.2 + " XP to Player lvl: " + playerLevel);
            getOut().println(YELLOW_ITALIC + "+" + (int) (xpPerMob * 0.2) + " xp" + RESET);
            setExperience(getExperience() + (int) (xpPerMob * 0.2));
        } else {
            // 0 xp
        }
        levelUp();
    }

    public void levelUp() {
        if (getExperience() >= 100) {

            setLevel(getLevel() + 1);
            setExperience(getExperience() % 100);

            setStrength(getStrength() + ((getLevel() - 1) * 2));
            setIntelligence(getIntelligence() + ((getLevel() - 1) * 2));
            setDexterity(getDexterity() + ((getLevel() - 1) * 2));
            setMainAttribute(getMainAttribute() + 1);
            setStaminaMax(getStaminaMax() + ((getLevel() - 1) * 2));
            setStaminaCurrent(getStaminaMax());
            setBaseDamage(getBaseDamage() + (getLevel() - 1));

            getOut().println(YELLOW_ITALIC + "You reached level " + getLevel() + RESET);
            getOut().println(YELLOW_ITALIC + "And you feel stronger and fresh" + RESET);
        }
    }

    //Implements IStaminaConsumption

    /**
     * @Override public void consumeStamina(int staAmount) {
     * getOut().println(YELLOW_ITALIC + "  [ -" + staAmount + " stamina ]" + RESET);
     * setStaminaCurrent(getStaminaCurrent() - staAmount);
     * }
     */

    // Hash Inventory
    public void initInventoryHash() {

        inventoryHash.put("Dungeon Map", new DungeonMap());
    }

    public void printInventoryHash() {
        getInventoryHash().forEach((s, item) -> System.out.println(item.getName()));
    }

    public Item getItem(String item) {
        return getInventoryHash().get(item);
    }


    public int printInventoryHashOwned() {
        System.out.println(YELLOW_ITALIC + "Inventory:" + RESET);
        itemNum = 0;
        getInventoryHash().forEach((s, item) -> {
            if (item.isOwned()) {
                itemNum++;
                System.out.println(itemNum + ". " + item.getName());
            }
        });
        return itemNum;
    }

    public int printStore() {

        System.out.println(BLUE_ITALIC + "What would you like to buy?" + RESET);
        itemNum = 0;
        getInventoryHash().forEach((s, item) -> {
            if (!item.isOwned()) {
                itemNum++;
                System.out.println(itemNum + ". " + item.getName() + "  " + YELLOW_BOLD +item.getPrice() + " c"+RESET);
            }
        });
        return itemNum;

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

    @Override
    public void searchRoom() {
        DiceSet roll = new DiceSet();
        inventory.forEach(item -> {
            if (Objects.equals(item.getName(), DungeonMap.class.getName()) && item.isOwned()) {
                System.out.println("DU ÄGER JONAS");
            } else {
                System.out.println("Tyvärrrrrr");
            }
        });
        if (roll.d20() + getLuck() > 15) {

        }
    }

    //Hero methods
    private StringBuilder xpMeter() {
        int exp = getExperience();
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
    public void dies(Game game) {
        setDead(true);
    }

    public void revive() {
        setRevives(getRevives() - 1);
        getOut().printNarrative(getName() + " rises again. Lets se how deep i can get this time..");
        setDead(false);
        setStaminaCurrent(getStaminaMax());
    }

    public String displayRevives() {
        int tempRevives = getRevives();
        StringBuilder rev = new StringBuilder();

        for (int i = 0; i < 2; i++) {
            if (tempRevives > 0) {
                rev.append(GREEN_BOLD + "㋛ " + RESET);
                tempRevives--;
            } else {
                rev.append(RED_BOLD + "㋛ " + RESET);
            }
        }
        return rev.toString();
    }

    public void getStatus() {
        System.out.println(getName() + getLevelToStatus());
        System.out.println("XP : " + xpMeter());
        System.out.println("STA: " + staminaMeter(getStaminaCurrent(), getStaminaMax()));
        System.out.println("STR: " + getStrength());
        System.out.println("INT: " + getIntelligence());
        System.out.println("DEX: " + getDexterity());
        System.out.println("DMG: " + getBaseDamage());
        System.out.println("REVIVES: " + displayRevives());
    }

    public int getMainAttribute() {
        return 0;
    }

    public void setMainAttribute(int newValue) {

    }

    public int calculateDamage() {
        DiceSet roll = new DiceSet();
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

    public boolean isAttacking() {
        return attacking;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public HashMap<String, Item> getInventoryHash() {
        return inventoryHash;
    }

    public void setInventoryHash(HashMap<String, Item> inventoryHash) {
        this.inventoryHash = inventoryHash;
    }

    public int getRevives() {
        return revives;
    }

    public void setRevives(int revives) {
        this.revives = revives;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}
