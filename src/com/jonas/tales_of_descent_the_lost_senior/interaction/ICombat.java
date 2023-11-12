package com.jonas.tales_of_descent_the_lost_senior.interaction;

import com.jonas.tales_of_descent_the_lost_senior.characters.*;


public interface ICombat {

    void attack(Monster monster);
    void attack(Hero player);

    void advancedAttack();

    void flee();

    void parry();

    void dies();



}
