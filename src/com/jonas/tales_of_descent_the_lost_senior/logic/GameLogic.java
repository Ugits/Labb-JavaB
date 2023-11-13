package com.jonas.tales_of_descent_the_lost_senior.logic;

import com.jonas.tales_of_descent_the_lost_senior.characters.Character;
import com.jonas.tales_of_descent_the_lost_senior.characters.Monster;
import com.jonas.tales_of_descent_the_lost_senior.characters.Hero;
import com.jonas.tales_of_descent_the_lost_senior.interaction.DiceSet;
import com.jonas.tales_of_descent_the_lost_senior.resources.OutputManipulation;

public class GameLogic  {
    DiceSet roll = new DiceSet();
    OutputManipulation out = new OutputManipulation();

    public void attackLogics(Character attacker, Character defender) {
        //check Main Attribute
        int dexMod = attacker.getDexterity() - defender.getDexterity(); // HERO DEX - MONSTER DEX = dexMOD
        int roll = this.roll.d20();
        if (roll == 1){
            out.println(attacker.getName() + " fumbles..");
            out.println(defender + " sises the opportunity!");
            attackLogics(defender,attacker);
            //defender.advancedAttack();
            //attacker.takeDamage(defender.getBaseDamage());
        } else if (roll + dexMod > defender.getDexterity()) {  // + LUCK ??
            System.out.println("HIT!");
            int damage = attacker.calculateDamage();
            out.println(defender.getName() + " takes " + damage + "dmg");
            defender.takeDamage(damage);
        }else {
            System.out.println( attacker.getName() + " missed..");
        }

        if (defender.getStaminaCurrent() <= 0) {
            defender.dies();
            //attacker.gainXp
        }
    }







}
