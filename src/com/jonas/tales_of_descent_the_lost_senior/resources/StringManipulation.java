package com.jonas.tales_of_descent_the_lost_senior.resources;

import java.util.Random;

public abstract class StringManipulation implements IColors {

    /**
     * <font color = #d77048>
     * <i>Prints char by char of string output with delay, and adds boldness</i>
     *
     * @param string String to process
     * @throws InterruptedException Thrown if interrupted while sleeping.
     */
    public void delayOutputNonColor(String string) throws InterruptedException {

        for (char c : string.toCharArray()) {

            System.out.print("\u001B[97m" + "\u001B[1m" + c + "\u001B[0m");
            Thread.sleep(50);
        }
    }

    /**
     * <font color = #d77048>
     * <i>Prints char by char of string output with delay, and adds color and boldness</i>
     * @param string The string, to manipulate
     * @throws InterruptedException Thrown if interrupted while sleeping.
     */
    public void delayOutputColor(String string) throws InterruptedException {
        for (char c : string.toCharArray()) {

            System.out.print(randomColorSwitch() + "\u001B[1m" + c + "\u001B[0m");
            Thread.sleep(50);
        }
    }

    /**
     * <font color = #d77048>
     *     <i>A switch that generates random Ansi colors</i>
     * @return ANSI escape code
     */
    public String randomColorSwitch (){
        Random rand = new Random();

        String escapeCode;
        switch (rand.nextInt(7)+1) {
            case 1:
                escapeCode = "\u001B[31m"; // Red
                break;
            case 2:
                escapeCode = "\u001B[38;5;208m"; // Orange
                break;
            case 3:
                escapeCode = "\u001B[33m"; // Yellow
                break;
            case 4:
                escapeCode = "\u001B[32m"; // Green
                break;
            case 5:
                escapeCode = "\u001B[34m"; // Blue
                break;
            case 6:
                escapeCode = "\u001B[35m"; // Indigo
                break;
            case 7:
                escapeCode = "\u001B[36m"; // Violet
                break;
            default:
                escapeCode = "\u001B[0m"; // Invalid Color (Black)
                break;
        }
        return escapeCode;
    }

    /**
     * <font color = #d77048>
     *     <i>Creates a line break</i>
     */
    public void br(){
        System.out.println();
    }

}
