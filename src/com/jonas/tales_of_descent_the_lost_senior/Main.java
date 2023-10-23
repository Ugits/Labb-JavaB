package com.jonas.tales_of_descent_the_lost_senior;

public class Main {
    public static void main(String[] args) {
        /* TODO: 2023-10-23
            *
            *
            * turn order
            *
            *  description - where are the character now (based on class?)
            *  (Start:)
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


    }
}
