package com.jonas.tales_of_descent_the_lost_senior.resources;

import com.jonas.tales_of_descent_the_lost_senior.Game;
import com.jonas.tales_of_descent_the_lost_senior.characters.heroes.Hero;
import com.jonas.tales_of_descent_the_lost_senior.player.Player;

import java.util.List;
import java.util.Objects;

public abstract class OutputManipulation implements IColors {

    /**
     * <font color = #d77048>
     * <i>Prints char by char of string output with delay, and adds boldness</i>
     *
     * @param string String to process
     * @throws InterruptedException Thrown if interrupted while sleeping.
     */
    public void delayPrint(String string) throws InterruptedException {

        for (char c : string.toCharArray()) {

            System.out.print(c);
            sleep(0);
        }
    }

    /**
     * <font color = #d77048>
     * <i>Creates a line break</i>
     */
    public void br() {
        System.out.println();
    }

    public void print(String string) {
        System.out.print(string);
    }

    public void println(String string) {
        System.out.println(string);
    }

    public void sleep(int milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }

    public void dialogIterator(List<String> dialogList) throws InterruptedException {
        for (String s : dialogList) {

            if (Objects.equals(s, RED_BOLD + "Knight" + RESET) || Objects.equals(s, BLUE_BOLD + "Mage" + RESET) || Objects.equals(s, GREEN_BOLD + "Ranger" + RESET)) {
                System.out.print(s);
                sleep(1000);

            } else {
                delayPrint(s);
                br();
            }
        }
    }

    public void narrator(String narration) throws InterruptedException {

        System.out.printf(narration);
        sleep(1000);
    }

    public void scene(String scene) throws InterruptedException {

        System.out.print(scene);
        br();
        sleep(1000);

    }

}
