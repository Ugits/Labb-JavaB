package com.jonas.tales_of_descent_the_lost_senior.player;

import com.jonas.tales_of_descent_the_lost_senior.characters.heroes.Hero;

public class Player {
    Hero hero = null;
    Hero friend1 = null;
    Hero friend2 = null;

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Hero getFriend1() {
        return friend1;
    }

    public void setFriend1(Hero friend1) {
        this.friend1 = friend1;
    }

    public Hero getFriend2() {
        return friend2;
    }

    public void setFriend2(Hero friend2) {
        this.friend2 = friend2;
    }
}
