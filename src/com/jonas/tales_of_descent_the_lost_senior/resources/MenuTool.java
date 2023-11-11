package com.jonas.tales_of_descent_the_lost_senior.resources;

import com.jonas.tales_of_descent_the_lost_senior.characters.monsters.Monster;
import com.jonas.tales_of_descent_the_lost_senior.player.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class MenuTool implements IColors {
    OutputManipulation console = new OutputManipulation();
    InputProcessing sc = new InputProcessing();
    // Menus
    boolean active;
    Player player;
    Monster monster;
    int roomNum;
    int floorNum;

    public MenuTool(Player player,Monster monster,int roomNum, int floorNum) {
        this.player = player;
        this.monster = monster;
        this.roomNum = roomNum;
        this.floorNum = floorNum;
    }



    public void combatMenu() {
        List<String> options = new ArrayList<>(Arrays.asList("", "", "", "", "", "", "", "", "", ""));
        int num = 0;
        getConsole().println(RED_BOLD + "Combat Menu: " + RESET);

        addToOptionsAndPrint(options, num, "Hit");
        num++;
        addToOptionsAndPrint(options, num, "Inventory");
        num++;
        addToOptionsAndPrint(options, num, "Hero Stats");
        num++;

        if (getRoomNum() != 1) {
            addToOptionsAndPrint(options, num, "Escape -> " + RED_BOLD + "[ " + RED_ITALIC + "Room " + getFloorNum() + "." + (getRoomNum() - 1) + RESET + RED_BOLD + " ]" + RESET);
        }

        userChoice(options);
        getConsole().br();
    }
    public void actionMenu() {
        List<String> options = new ArrayList<>(Arrays.asList("", "", "", "", "", "", "", "", "", ""));
        int num = 0;
        getConsole().println("Actions:");
        
        if (getRoomNum() != 1) {
            addToOptionsAndPrint(options, num, "Move Back");    // set int i in for - loop to previous index
            num++;
        }
        if (getRoomNum() != 5) {
            addToOptionsAndPrint(options, num, "Move Forward");     // continue loop
            num++;
        }
        if (getRoomNum() == 5) {
            addToOptionsAndPrint(options, num, "Move to Floor " + (getFloorNum() + 1));     // Iterate new dungeon
            num++;
        }
        addToOptionsAndPrint(options, num, "Search Room"); // roll for search + LUCK
        num++;
        addToOptionsAndPrint(options, num, "Inventory");   // call Inventory
        num++;
        addToOptionsAndPrint(options, num, "Hero Stats");   // call Stats
        // TODO: 2023-11-07     //  if dungeonMap is requierd. (use Dungeon Map)
        // TODO: 2023-11-07     //  if MysteryCube is used once. (use Mystery Cube)
        userChoice(options);
        getConsole().br();

    }

    public void addToOptionsAndPrint(List<String> options, int num, String print) {
        options.add(num, print);
    }

    public void userChoice(List<String> options) {

        do {
            active = false;

            printMenu(options);
            switch (getSc().getScanner().nextLine()) {
                case "1" -> executeChoice(options.get(0));
                case "2" -> executeChoice(options.get(1));
                case "3" -> executeChoice(options.get(2));
                case "4" -> executeChoice(options.get(3));
                case "5" -> executeChoice(options.get(4));
                case "6" -> executeChoice(options.get(5));
                case "7" -> executeChoice(options.get(6));
                case "8" -> executeChoice(options.get(7));
                case "9" -> executeChoice(options.get(8));
                case "10" -> executeChoice(options.get(9));
                default -> {
                   setActive(true);
                    System.out.println("Wrong input.. please try again   [ user Choice ]");
                }
            }
        } while (active);

    }
    private static void printMenu(List<String> options) {
        int num = 1;
        for (String s : options) {
            if (!Objects.equals(s, "")) {

                System.out.println(num + ". " + s);
                num++;
            }
        }
    }

    public void executeChoice(String option) {
        switch (option) {
            case "Hit" -> System.out.println("execute HIT");
            case "Inventory" -> System.out.println("execute INVENTORY");
            case "Hero Stats" -> getPlayer().getHero().getStatus();
            case "Search Room" -> System.out.println("execute SEARCH");
            case "Move Back" -> System.out.println("execute MOVE BACK");
            case "Move Forward" -> System.out.println("execute FORWARD");

            //case  -> System.out.println();
            //case  -> System.out.println();
            default -> {
                if (option.equals("Move to Floor " + (getFloorNum() + 1))) {
                    System.out.println("execute NEXT FLOOR");
                }
                if (option.equals("Escape -> " + RED_BOLD + "[ " + RED_ITALIC + "Room " + getFloorNum() + "." + (getRoomNum() - 1) + RESET + RED_BOLD + " ]" + RESET)) {
                    System.out.println("execute ESCAPE");
                } else {
                    setActive(true);
                    System.out.println("[DEBUG]    Fail in execute Choice    [DEBUG]");
                }
            }
        }
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    public OutputManipulation getConsole() {
        return console;
    }

    public void setConsole(OutputManipulation console) {
        this.console = console;
    }

    public InputProcessing getSc() {
        return sc;
    }

    public void setSc(InputProcessing sc) {
        this.sc = sc;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }
}
