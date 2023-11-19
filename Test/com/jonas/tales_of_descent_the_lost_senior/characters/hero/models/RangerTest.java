package com.jonas.tales_of_descent_the_lost_senior.characters.hero.models;

import com.jonas.tales_of_descent_the_lost_senior.characters.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangerTest {
    private  Character ranger;

    @BeforeEach
    public void setUp() {
        ranger = new Ranger();
    }

    @Test
    void getMainAttribute(){
        assertEquals(8,ranger.getMainAttribute());

        // TODO: 2023-11-19 Test expected main attribute for each level
        //ranger.setLevel(2);
        //ranger.getStatus();
        //assertEquals(11,ranger.getDexterity());


        // is the main attribute dextirity
        assertEquals(ranger.getDexterity(),ranger.getMainAttribute());
    }



    @Test
    void levelUp() {
       ranger.setExperience(140);
        if (ranger.getExperience() >= 100) {

            ranger.setLevel(ranger.getLevel() + 1);
            ranger.setExperience(ranger.getExperience() % 100);

        }
        assertEquals(2,ranger.getLevel());
        assertEquals(40, ranger.getExperience());
    }

    @Test
    void calculateDamage() {
        int min = ranger.getBaseDamage()+ ranger.getLuck() + 1;
        int max = ranger.getBaseDamage()+ ranger.getLuck() + 4;
        assertTrue(min <= ranger.calculateDamage() && max >= ranger.calculateDamage());
    }
}