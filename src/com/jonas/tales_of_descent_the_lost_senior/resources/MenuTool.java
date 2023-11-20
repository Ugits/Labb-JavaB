package com.jonas.tales_of_descent_the_lost_senior.resources;

import com.jonas.tales_of_descent_the_lost_senior.Game;
import com.jonas.tales_of_descent_the_lost_senior.characters.Character;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.Scene;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.dungeon.Room;
import com.jonas.tales_of_descent_the_lost_senior.logic.CombatLogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;


public class MenuTool extends Scene implements IColors {
    OutputManipulation out = new OutputManipulation();
    InputProcessing sc = new InputProcessing();
    CombatLogic logic = new CombatLogic();

    // Menus
    private int num;
    private Character hero;
    private Character monster;
    private int roomNum;
    private int floorNum;
    private boolean userChoiceActive;
    Room room;
    Game game;

    public MenuTool() {
    }

    /**
     * public MenuTool(int roomIndex, int floorIndex){
     * this.roomIndex = roomIndex;
     * this.floorIndex = floorIndex;
     * }
     */


    public MenuTool(Room room, Game game) {
        this.room = room;
        this.game = game;
        setHero(room.getHero());
        setMonster(room.getMonster());
        this.roomNum = room.getRoomNum();
        this.floorNum = room.getFloorNum();

    }

    /**
     * public MenuTool(Character hero, Character monster, int roomNum, int floorNum) {
     * setHero(hero);
     * setMonster(monster);
     * this.roomNum = roomNum;
     * this.floorNum = floorNum;
     * }
     */


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
                    //Integer.parseInt()
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
                getHero().attack(getMonster(), getGame());
                //room.setCombatMenuActive(false);
            }
            case "Inventory" -> {

                int items = getHero().printInventoryHashOwned();

                if (items == 0) {
                    getOut().printNarrative("-- Inventory empty --");
                } else {
                    System.out.println("0. Back");
                    AtomicReference<String> choice = new AtomicReference<>();
                    int tempChoice = getSc().tryNextInt();

                    setNum(0);
                    getHero().getInventoryHash().forEach((s, item) -> {
                        if (item.isOwned()) {
                            setNum(getNum() + 1);
                            if (getNum() == tempChoice) {
                                choice.set(item.getName());
                            }
                        }
                    });
                    //execute item
                    switch (choice.toString()) {
                        case "Mystery Box" -> {
                            getHero().getItem("Mystery Box").use(getGame());
                        }
                        case "Dungeon Map" -> {
                            getHero().getItem("Dungeon Map").use(getGame());
                        }
                        case "Lucky Dice Set" -> {
                            getHero().getItem("Lucky Dice Set").use(getGame());
                        }
                        case "Stamina Potion" -> {
                            getHero().getItem("Stamina Potion").use(getGame());
                        }
                        default -> System.out.println();
                    }
                    sc.waitForEnter();
                    sc.getScanner().nextLine();
                }

            }
            case "Hero Stats" -> {
                getHero().getStatus();
                sc.waitForEnter();
            }
            case "Search Room" -> {
                int digCost = 5;
                getHero().setStaminaCurrent(getHero().getStaminaCurrent() - digCost);
                System.out.println(YELLOW_ITALIC + "-" + digCost + " stamina");
                room.searchLoot();
            }
            case "Move Back" -> {
                getOut().printNarrative(getHero().getName() + " is heading back..");
                getGame().setRoomIndex(getGame().getRoomIndex() - 2);
                room.setActionMenuActive(false);
                sc.waitForEnter();
            }
            case "Move Forward" -> {
                getOut().printNarrative(getHero().getName() + " is moving on..");
                room.setActionMenuActive(false);
                sc.waitForEnter();
            }
            case "Move to Next Floor" -> {
                if (getFloorNum() < 5) {
                    getOut().printNarrative(getHero().getName() + " now descends to floor " + (getFloorNum() + 1));
                }
                room.setActionMenuActive(false);
                sc.waitForEnter();
            }

            default -> {

                if (option.equals("Escape -> " + RED_BOLD + "[ " + RED_ITALIC + "Room " + getFloorNum() + "." + (getRoomNum() - 1) + RESET + RED_BOLD + " ]" + RESET)) {
                    getHero().flee(room, getGame());
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

    public CombatLogic getLogic() {
        return logic;
    }

    public void setLogic(CombatLogic logic) {
        this.logic = logic;
    }

    @Override
    public Game getGame() {
        return game;
    }

    @Override
    public void setGame(Game game) {
        this.game = game;
    }
}
