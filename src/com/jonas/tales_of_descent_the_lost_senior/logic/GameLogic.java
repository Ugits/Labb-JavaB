package com.jonas.tales_of_descent_the_lost_senior.logic;

import com.jonas.tales_of_descent_the_lost_senior.characters.monsters.Monster;
import com.jonas.tales_of_descent_the_lost_senior.player.Player;

public class GameLogic {


    public void fight(Player player, Monster monster){
        System.out.println(player.getHero().getName() + " -VS- " + monster.getName());

    }



}
