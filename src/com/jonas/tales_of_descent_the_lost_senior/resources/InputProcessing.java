package com.jonas.tales_of_descent_the_lost_senior.resources;
import java.util.Scanner;

/**
 * <font color = #d77048>
 * <i>The `InputProcessing` class is responsible for handling user input
 *    and providing various input-related functionalities.</i>
 */
public class InputProcessing implements IColors {

    private Scanner scanner;

    /**
     * <font color = #d77048>
     * <i>Constructs object with custom-made scanner</i>
     */
    public InputProcessing() {
        setScanner(new Scanner(System.in));
    }

    public void waitForEnter(){

        System.out.println(YELLOW_ITALIC + "press enter" + RESET); // use some symbol
        getScanner().nextLine();
    }

    /**
     * <font color = #d77048>
     * <i>Validates that user input is of type int</i>
     *
     * @return An int from user
     */
    public int tryNextInt() {
        while (!getScanner().hasNextInt()) {
            System.out.println("That's not a number");
            getScanner().next();

        }
        return getScanner().nextInt();
    }

    /**
     * <font color = #d77048>
     * <i>Get user input. No input is refused. Only alphabetical symbols and spaces allowed</i>
     * @return a String value
     */
    public String nextAlphabeticalLine()  {
        String temp;
        do {
            temp = getScanner().nextLine().trim();
            if (temp.isEmpty() || !temp.matches("^[a-öA-Ö ]*$")) {
                System.out.println("Give me some letters...");
            }
        } while (temp.isEmpty() || !temp.matches("^[a-öA-Ö ]*$"));
        return temp;
    }

    /**
     * <font color = #d77048>
     * <i>Call Scanner object</i>
     * @return scanner obj
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * <font color = #d77048>
     * <i>Instantiates the Scanner</i>
     *
     * @param scanner Scanner(System.in)
     */
    private void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

}

