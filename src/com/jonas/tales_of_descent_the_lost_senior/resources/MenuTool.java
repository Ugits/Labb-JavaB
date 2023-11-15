package com.jonas.tales_of_descent_the_lost_senior.resources;

import com.jonas.tales_of_descent_the_lost_senior.characters.Character;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.dungeon.Room;
import com.jonas.tales_of_descent_the_lost_senior.logic.GameLogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class MenuTool implements IColors {
    OutputManipulation out = new OutputManipulation();
    InputProcessing sc = new InputProcessing();
    GameLogic logic = new GameLogic();
    // Menus
    private int num;
    private Character hero;
    private Character monster;
    private int roomNum;
    private int floorNum;
    private boolean userChoiceActive;
    Room room;

    public MenuTool(Room room) {
        this.room = room;
        setHero(room.getHero());
        setMonster(room.getMonster());
        this.roomNum = room.getRoomNum();
        this.floorNum = room.getFloorNum();

    }

    public MenuTool(Character hero, Character monster, int roomNum, int floorNum) {
        setHero(hero);
        setMonster(monster);
        this.roomNum = roomNum;
        this.floorNum = floorNum;
    }


    public void encounterStatus() {
        StringBuilder firstLine = new StringBuilder();
        firstLine.append(" ")
                .append(getHero().getName())
                .append(getHero().getLevelToStatus());

        while (firstLine.length() <= 55) firstLine.append(" ");

        firstLine.append(getMonster().getName())
                .append(getMonster().getLevelToStatus());

        getOut().println(firstLine.toString());

        getOut().print(getHero().staminaMeter(getHero().getStaminaCurrent(), getHero().getStaminaMax()));
        getOut().print("  " + YELLOW_ITALIC + "VS" + RESET + "  ");
        getOut().println(getMonster().staminaMeter(getMonster().getStaminaCurrent(), getMonster().getStaminaMax()));

        getOut().br();
    }

    public void combatMenu() {

        encounterStatus();

        num = 0;

        List<String> options = new ArrayList<>(Arrays.asList("", "", "", "", "", "", "", "", "", ""));

        getOut().println(RED_BOLD + "Combat Menu: " + RESET);
        addToOptions(options, "Hit");
        addToOptions(options, "Inventory");
        addToOptions(options, "Hero Stats");

        if (getRoomNum() != 1) {
            addToOptions(options, "Escape -> " + RED_BOLD + "[ " + RED_ITALIC + "Room " + getFloorNum() + "." + (getRoomNum() - 1) + RESET + RED_BOLD + " ]" + RESET);
        }

        userChoice(options);
        getOut().br();
    }

    public void actionMenu() {

        num = 0;

        List<String> options = new ArrayList<>(Arrays.asList("", "", "", "", "", "", "", "", "", ""));
        getOut().println("Actions:");
        switch (getRoomNum()) {
            case 1 -> {
                addToOptions(options, "Move Forward");     // continue loop
                addToOptions(options, "Search Room"); // roll for search + LUCK
                addToOptions(options, "Inventory");   // call Inventory
                addToOptions(options, "Hero Stats");   // call Stats
            }
            case 2, 3, 4 -> {
                addToOptions(options, "Move Back");    // set int i in for - loop to previous index
                addToOptions(options, "Move Forward");     // continue loop
                addToOptions(options, "Search Room"); // roll for search + LUCK
                addToOptions(options, "Inventory");   // call Inventory
                addToOptions(options, "Hero Stats");   // call Stats
            }
            case 5 -> {
                addToOptions(options, "Move Back");    // set int i in for - loop to previous index
                addToOptions(options, "Move to Next Floor");     // Iterate new dungeon
                addToOptions(options, "Search Room"); // roll for search + LUCK
                addToOptions(options, "Inventory");   // call Inventory
                addToOptions(options, "Hero Stats");   // call Stats
            }
        }

        /**
         *       if (getRoomNum() != 1) {
         addToOptions(options, "Move Back");    // set int i in for - loop to previous index
         }
         if (getRoomNum() != 5) {
         addToOptions(options, "Move Forward");     // continue loop
         }
         if (getRoomNum() == 5) {
         addToOptions(options, "Move to Next Floor");     // Iterate new dungeon
         System.out.println(RED_BOLD+"inside == 5"+RESET);
         }
         addToOptions(options, "Search Room"); // roll for search + LUCK
         addToOptions(options, "Inventory");   // call Inventory
         addToOptions(options,  "Hero Stats");   // call Stats
         // TODO: 2023-11-07     //  if dungeonMap is requierd. (use Dungeon Map)
         // TODO: 2023-11-07     //  if MysteryCube is used once. (use Mystery Cube)
         */
        userChoice(options);
        getOut().br();

    }

    public void addToOptions(List<String> options, String print) {
        options.set(num, print);
        num++;
    }

    public void userChoice(List<String> options) {

        do {
            userChoiceActive = false;

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
                    setUserChoiceActive(true);
                    System.out.println("Wrong input.. please try again   [ user Choice ]");
                }
            }
        } while (userChoiceActive);

    }

    private void printMenu(List<String> options) {
        int num = 1;
        for (String s : options) {
            if (!Objects.equals(s, "")) {

                System.out.println(num + ". " + s);
                num++;
            }
        }
    }

    public void executeChoice(String option) {
        getOut().br();

        switch (option) {
            case "Hit" -> {

                getHero().attack(getMonster());
                room.setCombatMenuActive(false);
                //if player dead, revive
                //if Monster not dead, get logic(Monster, Hero)
            }
            case "Inventory" -> {
                System.out.println("execute INVENTORY");
            }
            case "Hero Stats" -> {
                getHero().getStatus();
                sc.waitForEnter();
            }
            case "Search Room" -> System.out.println("execute SEARCH");
            case "Move Back" -> System.out.println("execute MOVE BACK");
            case "Move Forward" -> {
                getOut().printNarrative(getHero().getName() + " is moving on..");
                room.setActionMenuActive(false);
                sc.waitForEnter();

            }
            case "Move to Next Floor" -> {
                getOut().printNarrative(getHero().getName() + " now descends to floor " + (getFloorNum() + 1));
                room.setActionMenuActive(false);
                sc.waitForEnter();

            }

            //case  -> System.out.println();
            //case  -> System.out.println();
            default -> {

                if (option.equals("Escape -> " + RED_BOLD + "[ " + RED_ITALIC + "Room " + getFloorNum() + "." + (getRoomNum() - 1) + RESET + RED_BOLD + " ]" + RESET)) {
                    System.out.println("execute ESCAPE");
                } else {
                    setUserChoiceActive(true);
                    System.out.println("[DEBUG]    Fail in execute Choice    [DEBUG]");
                }
            }
        }
    }

    public boolean isUserChoiceActive() {
        return userChoiceActive;
    }

    public void setUserChoiceActive(boolean userChoiceActive) {
        this.userChoiceActive = userChoiceActive;
    }

    public Character getHero() {
        return hero;
    }

    public void setHero(Character hero) {
        this.hero = hero;
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

    public OutputManipulation getOut() {
        return out;
    }

    public void setOut(OutputManipulation out) {
        this.out = out;
    }

    public InputProcessing getSc() {
        return sc;
    }

    public void setSc(InputProcessing sc) {
        this.sc = sc;
    }

    public Character getMonster() {
        return monster;
    }

    public void setMonster(Character monster) {
        this.monster = monster;
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public GameLogic getLogic() {
        return logic;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

}
