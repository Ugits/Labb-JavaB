package com.jonas.tales_of_descent_the_lost_senior;

import com.jonas.tales_of_descent_the_lost_senior.resources.IColors;

public class Main implements IColors {

    public static void main(String[] args){


        new Game();





        /* TODO: 2023-10-23
            *
            *
            * turn order
            *
            *  (Start:)
            *  description - where are the character now (based on class?)
            *  //IF (room[floor.length - 1] == room[i]) description and descend.
            *  action menu - move deeper / search room / show Inventory / character stats / shop (only availeble at start, or search)
                * move deeper:  -stamina , next room,
                    * //IF (room[floor.length - 1] == room[i]) description and descend.
                    * (floorCount++)(adjust environment)(gold/mob)(luck)  (if (floor == 50?) boss floor)
                    *
                *
                *  search: roll if any: (treasure, trap (dmg, loose item, monster encounter), passage)
                            - if any true: roll on corresponding table for outcome.
                            * improve luck, by items (+ in search roll)
                * show inventory: display items
                * shop: sell items / upgrade items.
            *
            *  if encounter
                * (hero interface)
                * Flee
                * Fight -> into combat phase
                * Fool -> how?
                    * seduce
                    * hide
                    * throw rock
                    * scare
            *
            *  Combat phase
                *
                * Hit (level unlock new attacks)
                * parry next (if (success == true) free counterattack)
                * Escape (- mayor stamina)
                    * if (dead == true && Resurrections > 0) revive; resurrection--;
                * else
                * (Continue;)
             *

        * */


        //System.out.println(scene1.getDescription());

        //Scene scene2 = new Waterfall();
        //scene2.setDescription("at the waterfall");
        //System.out.println(scene2.getDescription());

        //Scene scene3 = new IntoTheDark();
        //scene3.setDescription("its dark in here");
        //System.out.println(scene3.getDescription());

        //scene1.dialogIterator();


    }


    /**
     * CustomString print = new CustomString();
     Room room1 = new Room();
     System.out.println(room1.monster.getName());
     System.out.println(room1.monster.getStamina());
     System.out.println(room1.monster.getDamage());
     System.out.println(room1.monster.isDead());

     room1.monster.attack();
     room1.monster.advancedAttack();
     */
    //Part of intro
    //System.out.println(print.introPart3);

    //room description
    //System.out.println(print.roomDescriptionExample);

    //action menu
    //System.out.println(print.actionMenu);

    //combat menu
    //System.out.println(print.combatMenu);
}

