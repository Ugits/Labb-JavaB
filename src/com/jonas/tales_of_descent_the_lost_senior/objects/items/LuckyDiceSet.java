package com.jonas.tales_of_descent_the_lost_senior.objects.items;

import com.jonas.tales_of_descent_the_lost_senior.Game;
import com.jonas.tales_of_descent_the_lost_senior.objects.Item;

public class LuckyDiceSet extends Item {

    public LuckyDiceSet() {
        super("Lucky Dice Set", 500, false);
    }

    @Override
    public void use(Game game) {
        getOut().printNarrative(game.getPlayer().getHero().getName() + " rolls the d20...");
        getOut().sleep(1000);
        getOut().printNarrative(game.getPlayer().getHero().getName() + " .. 20!");
    }
}
