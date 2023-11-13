package com.jonas.tales_of_descent_the_lost_senior.interaction;

import com.jonas.tales_of_descent_the_lost_senior.characters.*;
import com.jonas.tales_of_descent_the_lost_senior.characters.Character;


public interface ICombat {

    void attack(Character character);


    void advancedAttack();

    void flee();

    void parry();

    void dies();



}
