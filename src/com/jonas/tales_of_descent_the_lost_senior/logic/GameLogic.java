package com.jonas.tales_of_descent_the_lost_senior.logic;

import com.jonas.tales_of_descent_the_lost_senior.characters.Character;
import com.jonas.tales_of_descent_the_lost_senior.interaction.DiceSet;
import com.jonas.tales_of_descent_the_lost_senior.resources.InputProcessing;
import com.jonas.tales_of_descent_the_lost_senior.resources.OutputManipulation;

import java.util.Objects;

public class GameLogic {
    DiceSet roll = new DiceSet();
    OutputManipulation out = new OutputManipulation();
    InputProcessing sc = new InputProcessing();

    public void attackLogics(Character hero, Character attacker, Character defender) {
        sc.waitForEnter();
        // Attacker/Defender diff in dex
        int dexMod = attacker.getDexterity() - defender.getDexterity(); // HERO DEX - MONSTER DEX = dexMOD

        // roll for hit
        int roll = this.roll.d20();
        if (roll == 1) {
            // Critical Miss = free counterattack from defender, 100% hit chans
            out.println(attacker.getName() + " fumbles..");
            out.sleep(1000);

            int dmg = defender.calculateDamage();
            out.println(defender.getName() + " sises the opportunity! And inflicts " + dmg + " damage to " + attacker.getName());
            attacker.takeDamage(dmg);
            sc.waitForEnter();
            //attackLogics(defender, attacker);
            //defender.attack(attacker);
            //attacker.takeDamage(defender.getBaseDamage());
        } else if (roll + dexMod > defender.getDexterity()) {  // + LUCK ??
            System.out.println("HIT!");
            int damage = attacker.calculateDamage();
            out.println(defender.getName() + " takes " + damage + " damage");
            defender.takeDamage(damage);
            sc.waitForEnter();
        } else {
            System.out.println(attacker.getName() + " missed..");
        }

        if (defender.getStaminaCurrent() <= 0) {
            defender.dies();
            if (attacker == hero){
                attacker.gainExp(defender.getLevel());
                sc.waitForEnter();
            }
        }
        if(attacker.getStaminaCurrent() <= 0){
            attacker.dies();
            if (defender == hero){
                defender.gainExp(attacker.getLevel());
                sc.waitForEnter();
            }
        }

    }


}
