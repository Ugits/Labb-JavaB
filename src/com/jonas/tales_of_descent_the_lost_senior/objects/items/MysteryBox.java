package com.jonas.tales_of_descent_the_lost_senior.objects.items;

import com.jonas.tales_of_descent_the_lost_senior.Game;
import com.jonas.tales_of_descent_the_lost_senior.objects.Item;

import static com.jonas.tales_of_descent_the_lost_senior.resources.IColors.*;

public class MysteryBox extends Item {
    int index;
    boolean active;
    int inStock;


    public MysteryBox() {
        super("Mystery Box", 0, true);
    }


    @Override
    public void use(Game game) {

        getOut().printNarrative("description for the magic cube unfolds");
        magicShop(game);
        //Trigger store
        // TODO: 2023-11-18 Build store
        // init all items in hero
        // call them from menu tool
        // item abilitys, keep in every Item, if possible
    }

    public void magicShop(Game game) {

        System.out.println(BLUE_ITALIC + "Welcome traveller!" + RESET);

        active = true;
        while (active) {
            inStock = game.getPlayer().getHero().printStore();
            if (inStock == 0) {
                getOut().printNarrative("-- Inventory empty --");
                active = false;
            } else {

                System.out.println(YELLOW_BOLD + "Pouch: " + game.getPlayer().getHero().getCoins() + " Coins" + RESET);

                int tempChoice = getSc().tryNextInt();
                getSc().getScanner().nextLine();
                setIndex(0);
                game.getPlayer().getHero().getInventoryHash().forEach((s, item) -> {
                    if (!item.isOwned()) {
                        setIndex(getIndex() + 1);
                        if (getIndex() == tempChoice) {
                            dealOrNot(game, item);
                        }
                    }
                });
            }
            getOut().br();
            if (active) {
                System.out.println("Do you need something else?" + "  [Y / N]");
                switch (getSc().nextAlphabeticalLine().toLowerCase()) {
                    case "n", "no" -> active = false;
                }
            }
        }
    }

    public void dealOrNot(Game game, Item item) {

        System.out.println("Do you wish to buy " + item.getName() + "  [Y / N]");

        switch (getSc().nextAlphabeticalLine().toLowerCase()) {
            case "y", "yes" -> {
                if (game.getPlayer().getHero().getCoins() >= item.getPrice()) {
                    game.getPlayer().getHero().getItem(item.getName()).setOwned(true);
                    game.getPlayer().getHero().setCoins(game.getPlayer().getHero().getCoins() - item.getPrice());
                    getOut().printItemPickUp(item.getName());
                } else {
                    System.out.println("Looks like your out of founds..");
                }
            }
            default -> System.out.println("if you don't need it..");
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    // build store
}
