package com.jonas.tales_of_descent_the_lost_senior.characters.monster.models;

import com.jonas.tales_of_descent_the_lost_senior.Game;
import com.jonas.tales_of_descent_the_lost_senior.characters.Character;
import com.jonas.tales_of_descent_the_lost_senior.characters.monster.Monster;

public class Goblin extends Monster {

    public Goblin(int floorNum) {
        super(
                "Goblin",
                floorNum,
                10,
                6,
                8,
                2,
                5,
                false);
    }

    @Override
    public void attack(Character hero, Game game) {
        System.out.println("The goblin swings his dagger");
        attackLogics(hero,this,hero,game);
        hero.setAttacking(true);
        // damage player
    }




    @Override
    public void dies(Game game) {
        getOut().printNarrative("GOBLIN DIES");
        setDead(true);
    }

}
