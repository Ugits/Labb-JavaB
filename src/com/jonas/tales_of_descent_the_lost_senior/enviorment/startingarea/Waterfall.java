package com.jonas.tales_of_descent_the_lost_senior.enviorment.startingarea;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.Scene;
import com.jonas.tales_of_descent_the_lost_senior.resources.InputProcessing;

public class Waterfall extends Scene {
    InputProcessing sc = new InputProcessing();

    public Waterfall() {
        super(0, 0);
        setDescription(waterfallDescription);
    }

    public void description() throws InterruptedException {
        // "scene"
        scene(sceneHead);
        // scene description
        scene(getDescription());
    }



}
