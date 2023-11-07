package com.jonas.tales_of_descent_the_lost_senior.resources;

import com.jonas.tales_of_descent_the_lost_senior.characters.monsters.Monster;

import java.util.List;
import java.util.Objects;

public class OutputManipulation extends CustomStrings {

    /**
     * <font color = #d77048>
     * <i>Prints char by char of string output with delay, and adds boldness</i>
     *
     * @param string String to process
     * @throws InterruptedException Thrown if interrupted while sleeping.
     */
    public void delayPrint(int sleep, String string) throws InterruptedException {

        for (char c : string.toCharArray()) {
            System.out.print(c);
            sleep(sleep);
        }
        br();
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

            if (Objects.equals(s, knightHead) || Objects.equals(s, mageHead) || Objects.equals(s, rangerHead)) {
                printHeader(s);
                sleep(500);

            } else {
                delayPrint(0, s);
                br();
            }
        }
    }

    public void printScene(String description) throws InterruptedException {
        delayPrint(20, YELLOW_ITALIC + "* " + (description) + YELLOW_ITALIC + " *" + RESET);
        sleep(1000);
        br();

    }

    public void printNarrative(String narration) throws InterruptedException {
        delayPrint(0, PURPLE_ITALIC + "'" + narration + PURPLE_ITALIC + "'" + RESET);
        sleep(1000);
        br();
    }

    public void printHeader(String scene) throws InterruptedException {
        println(YELLOW_BOLD + "[ " + YELLOW_ITALIC + scene +RESET +YELLOW_BOLD + " ]" + RESET);
        sleep(1000);
    }

    public void printMonster(Monster monster) throws InterruptedException {
        delayPrint(0, RED + "-- You encountered a " + monster.getName() +" --"+ RESET);
        br();
    }
}
