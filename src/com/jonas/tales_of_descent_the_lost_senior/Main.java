package com.jonas.tales_of_descent_the_lost_senior;

public class Main {
    public static void main(String[] args) {
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

        //Part of intro

        String introPart3 = """
                You just came throughout the waterfall opening you eyes. You take a few steps,
                into the stripes of light that leaks from the cracked open ceiling.
                you see a trail of lit torches along the walls. Now theres no turning back.
                While flickering fire leads you down the hall, you suddenly notice an updraft wind, you stopped.
                Slowly, you look down, and there is nothing there. nothing but an endless fall to death.
                While thinking that you just consumed the last bit of luck, you attached your eyes to a ladder.
                Wailing down in the deep, you realize, its also the only option to get to were you need.
                                        
                So you descend, the wooden craft you climbing feels pretty sturdy,
                and you try to project comfort upon yourself by saying..
                "this ain't so bad..."
                but... *sniff* *sniff*
                what is that?...
                ... rotten meat?
                                
                Reaching solid ground, you turn around..
                """;
        System.out.println(introPart3);

        //room description
        String roomDesctiptionExample = """ 
                Actions:
                """;
        System.out.println(roomDesctiptionExample);


        //action menu
        String actionMenu = """ 
                Actions:
                1. Move Deeper
                2. Search Room
                3. Inventory
                4. Character Stats
                                
                """;
        System.out.println(actionMenu);

    }
}
