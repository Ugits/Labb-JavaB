package com.jonas.tales_of_descent_the_lost_senior.enviorment.startingarea;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.Scene;
import com.jonas.tales_of_descent_the_lost_senior.resources.InputProcessing;

public class TheThreeFriends extends Scene {

    public TheThreeFriends() throws InterruptedException {
        super(0, 0);
        setDescription(theThreeFriendsDescription);
    }

    public void runScene() throws InterruptedException {
        InputProcessing sc = new InputProcessing();
        // "scene"
        System.out.println(sceneHead);
        // scene description
        delayPrint(getDescription());
        br();
        // friends by the fire
        dialogIterator(theFriends);
    }


}
