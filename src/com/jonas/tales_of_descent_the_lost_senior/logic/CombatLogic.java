package com.jonas.tales_of_descent_the_lost_senior.logic;

import com.jonas.tales_of_descent_the_lost_senior.Game;
import com.jonas.tales_of_descent_the_lost_senior.characters.Character;
import com.jonas.tales_of_descent_the_lost_senior.interaction.DiceSet;
import com.jonas.tales_of_descent_the_lost_senior.resources.InputProcessing;
import com.jonas.tales_of_descent_the_lost_senior.resources.OutputManipulation;

import static com.jonas.tales_of_descent_the_lost_senior.resources.IColors.RED_BOLD;

public class CombatLogic {
    DiceSet roll = new DiceSet();
    OutputManipulation out = new OutputManipulation();
    InputProcessing sc = new InputProcessing();

    public void attackLogics(Character hero, Character attacker, Character defender, Game game) {
        sc.waitForEnter();
        // Attacker/Defender diff in dex
        int dexMod = attacker.getDexterity() - defender.getDexterity(); // HERO DEX - MONSTER DEX = dexMOD

        // roll for hit
        int roll = this.roll.d20();
        //System.out.println(RED_BOLD + "[DEBUG] \n" + "ROLL: " + roll + "\nDEX-MOD: " + dexMod + "\nTOTAL: "+ (roll + dexMod) + "\nHit over Defender DEX: " + defender.getDexterity()+"\n[DEBUG]\n");
        if (roll == 1) {
            // Critical Miss = free counterattack from defender, 100% hit chans
            out.println(attacker.getName() + " fumbles..");
            out.sleep(1000);

            int dmg = defender.calculateDamage();
            out.println(defender.getName() + " sises the opportunity! And inflicts " + dmg + " damage to " + attacker.getName());
            attacker.takeDamage(dmg);
            sc.waitForEnter();

        } else if (roll + dexMod + attacker.getLuck() >= defender.getDexterity()) {  // + LUCK ??
            System.out.println("HIT!");
            int damage = attacker.calculateDamage();
            out.println(defender.getName() + " takes " + damage + " damage");
            defender.takeDamage(damage);
            sc.waitForEnter();
        } else {
            System.out.println(attacker.getName() + " missed..");
            sc.waitForEnter();
        }

        if (defender.getStaminaCurrent() <= 0) {
            defender.dies(game);
            if (attacker == hero) {
                attacker.lootMonster();
                attacker.gainExp(defender.getLevel());

                sc.waitForEnter();
            }else {
                out.printNarrative(defender.getName() + " is no more!");
            }
        }

        if (attacker.getStaminaCurrent() <= 0) {
            attacker.dies(game);
            if (defender == hero) {
                defender.lootMonster();
                defender.gainExp(attacker.getLevel());
                sc.waitForEnter();
            }else {
                out.printNarrative(attacker.getName() + " is no more!");
            }
        }
    }
}
