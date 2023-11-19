package com.jonas.tales_of_descent_the_lost_senior.objects.items;

import com.jonas.tales_of_descent_the_lost_senior.Game;
import com.jonas.tales_of_descent_the_lost_senior.objects.Item;

public class StaminaPotion extends Item {

    public StaminaPotion() {
        super("Stamina Potion", 25, false);
    }

    @Override
    public void use(Game game) {
        getOut().printNarrative("*glunk* *glunk* *glunk* *glunk*");
        getOut().printNarrative("Ahhh...");
        setOwned(false);
        game.getPlayer().getHero().setStaminaCurrent(game.getPlayer().getHero().getStaminaMax());
    }
}


