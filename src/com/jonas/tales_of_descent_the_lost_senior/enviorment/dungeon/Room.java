package com.jonas.tales_of_descent_the_lost_senior.enviorment.dungeon;

import com.jonas.tales_of_descent_the_lost_senior.characters.monsters.Goblin;
import com.jonas.tales_of_descent_the_lost_senior.characters.monsters.Monster;
import com.jonas.tales_of_descent_the_lost_senior.characters.monsters.NoMonster;
import com.jonas.tales_of_descent_the_lost_senior.characters.monsters.PackOfRats;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.Scene;
import com.jonas.tales_of_descent_the_lost_senior.interaction.DiceSet;
import com.jonas.tales_of_descent_the_lost_senior.player.Player;
import com.jonas.tales_of_descent_the_lost_senior.resources.MenuTool;

public class Room extends Scene {
    DiceSet roll = new DiceSet();
    MenuTool menu;
    //public boolean hasMonster;
    public int difficulty;
    public int floorNum;
    public int roomNum;
    public boolean hasStore;
    public boolean hasTreasure;
    public boolean hasMonster;
    public Monster monster;


    public Room(Player player, int floorNum, int roomNum) {
        super(player, -floorNum, -floorNum);
        this.difficulty = floorNum;
        this.floorNum = floorNum;
        this.roomNum = roomNum;
        setMenu(new MenuTool(getPlayer(), getMonster(), getRoomNum(), getFloorNum()));

        if (getPlayer().getHero().isFirstTimeInDungeon()) {
            this.monster = new PackOfRats(); // inject floorNum for monster lvl
            setHasMonster(true);
            setDescription("Investigating the foul smell, you discover rats devouring a corpse. \n As you approach, the vermin abruptly turn their attention toward you, hissing in an unnerving standoff.");
            getPlayer().getHero().setFirstTimeInDungeon(false);

        } else {
            this.monster = (roll.d20() > 12) ? fetchMonster(roll.dCustom(2)) : new NoMonster(); // Abstract clas cant be null?
            setDescription(genDescription());
        }

        // has store todo implement store
        // has tressure todo modify with LUCK //

        this.hasTreasure = roll.d20() > 16;

        // set description


    }

    @Override
    public void runScene() {
        // Print scene

        getConsole().printHeader("Room " + getFloorNum() + "." + getRoomNum());
        getConsole().printScene(getDescription());
        if (hasMonster) {
            monsterEncounter();
        }
        getMenu().actionMenu();
    }


    private void monsterEncounter() {
        getConsole().printMonster(getMonster());
        encounterStatus();
        getMenu().combatMenu();
    }





    public void encounterStatus() {
        StringBuilder firstLine = new StringBuilder();
        firstLine.append(" ")
                .append(getPlayer().getHero().getName())
                .append(getPlayer().getHero().getLevelToStatus());

        while (firstLine.length() <= 55) firstLine.append(" ");

        firstLine.append(getMonster().getName())
                .append(getMonster().getLevelToStatus());

        println(firstLine.toString());

        print(getPlayer().getHero().staminaMeter(getPlayer().getHero().getStaminaCurrent(),getPlayer().getHero().getStaminaMax()));
        print("  " + YELLOW_ITALIC + "VS" + RESET + "  ");
        println(getMonster().staminaMeter(getMonster().getStaminaCurrent(),getMonster().getStaminaMax()));

        br();
    }
    //roll what monster
    public Monster fetchMonster(int roll) {
        this.hasMonster = true;
        Monster temp = null;
        switch (roll) {
            case 1 -> {
                temp = new PackOfRats();
            }
            case 2 -> {
                temp = new Goblin();
            }

            default -> {
                System.out.println("check random number in fetch Monster");
            }
        }

        return temp;
    }

    public String genDescription() {

        return switch (getFloorNum()) {
            case 1, 2, 3 -> shallowFloors();
            case 4, 5, 6, 7 -> midDepthFloors();
            case 8, 9, 10 -> deeperFloors();
            default -> throw new IllegalStateException("Unexpected value: " + roll.d20());
        };
    }

    public String shallowFloors() {

        return switch (roll.d20()) {
            case 1 ->
                    "The corridors, softly lit by scattered torches, reveal murals depicting forgotten tales of heroic deeds and past glory, instilling a sense of hope and exploration.";
            case 2 ->
                    "Within a chamber, a faint glow permeates through cracks in the ceiling, casting a gentle light on ancient artifacts, lending a sense of quiet wonder and a hint of distant sunlight.";
            case 3 ->
                    "Meandering through well-maintained pathways reveals remnants of a forgotten era, offering a welcoming ambiance with the air carrying a hint of an earthy fragrance.";
            case 4 ->
                    "A spacious room unveils clear paths among weathered architecture, inviting a sense of historical reverence tinged with the echoes of distant stories and a whisper of forgotten voices.";
            case 5 ->
                    "The well-preserved corridors create a sense of tranquility and openness, hinting at former grandeur now overrun by nature, fostering a contemplative and serene mood.";
            case 6 ->
                    "Sunlight softly filters through the chamber, illuminating the worn yet elegant structures, hinting at the beauty of the past and offering a tranquil, exploratory ambiance.";
            case 7 ->
                    "A well-lit passageway hints at a comforting sense of safety, with remnants of previous explorers paving the way, fostering a curious and cautious atmosphere.";
            case 8 ->
                    "Dim light reveals scattered remnants of bygone eras, granting a glimpse of the past's opulence now long forgotten, evoking a mixture of awe and contemplation.";
            case 9 ->
                    "Gentle illumination in the corridors exposes forgotten relics and hints of a lost age, offering an almost serene yet inviting environment that invites curiosity and contemplation.";
            case 10 ->
                    "Softly glowing passages suggest ancient beauty amidst decay, creating an atmosphere that is welcoming and rich with a quiet sense of historical significance.";
            case 11 ->
                    "Faint sunlight seeps through cracks above, offering a glimpse of a tranquil outside world within the space, instilling a sense of reassurance and an inviting exploratory mood.";
            case 12 ->
                    "Meandering through softly lit corridors unveils forgotten relics and architectural remnants, radiating a sense of forgotten beauty and sparking curiosity and contemplation.";
            case 13 ->
                    "Softly lit paths hint at aged remnants of past grandeur, offering a historical significance that invites both contemplation and cautious exploration.";
            case 14 ->
                    "The well-lit surroundings reveal a wealth of historical significance, with ancient artifacts hinting at past prosperity, creating an environment rich in both curiosity and caution.";
            case 15 ->
                    "A chamber softly illuminated by scattered torchlight presents aged structures and echoes of history, offering an environment that is both contemplative and welcoming.";
            case 16 ->
                    "Soft illumination reveals remnants of a forgotten era, radiating a sense of historical importance that encourages both curiosity and caution.";
            case 17 ->
                    "Faint light filtering through cracks paints a tranquil scene within the space, suggesting a comforting yet exploratory atmosphere.";
            case 18 ->
                    "Within the softly lit chambers, forgotten relics and remnants of ancient architecture suggest a serene yet engaging environment rich with historical significance.";
            case 19 ->
                    "Softly glowing corridors invite exploration amid ancient beauty amidst decay, creating an inviting atmosphere rich with contemplation and curiosity.";
            case 20 ->
                    "Scattered torches light the corridors, uncovering murals and aged remnants, offering a sense of historical significance and a mood conducive to exploration and curiosity.";
            default -> throw new IllegalStateException("Unexpected value: " + roll.d20());
        };
    }

    public String midDepthFloors() {

        return switch (roll.d20()) {
            case 1 ->
                    "Dimly lit passageways reveal obscured areas and partially collapsed walls, presenting challenges in navigation, fostering a growing sense of claustrophobia and unease.";
            case 2 ->
                    "Debris-strewn corridors and faint light cast shadows and whispers of ghostly echoes, enveloping the surroundings in a chilling stillness and a foreboding ambiance.";
            case 3 ->
                    "The dimly lit pathways twist into labyrinthine routes, the air growing colder and the silence becoming more ominous, amplifying a sense of urgency and unease.";
            case 4 ->
                    "Shadows and debris obscure the dimly lit routes, offering a menacing ambiance with whispers of ghostly echoes and unsettling, faint sounds.";
            case 5 ->
                    "The oppressive silence hangs heavily in darkened corridors, the surroundings twisting into obscure paths that amplify confusion and unease.";
            case 6 ->
                    "Dim, flickering light casts eerie shadows and faint echoes within labyrinthine routes, instilling a sense of foreboding and urgency.";
            case 7 ->
                    "As light dims, the surroundings become menacing, and cold drafts and ominous echoes pervade the space, evoking a sense of disquiet and urgency.";
            case 8 ->
                    "The oppressive silence grows in almost impassable pathways, revealing collapsed structures and hidden passages that amplify a sense of desperation and isolation.";
            case 9 ->
                    "Almost imperceptible light engulfs the environment, thick with an unsettling silence and an ever-growing sense of disorientation and urgency.";
            case 10 ->
                    "Obscure and menacing routes become disorienting and foreboding, instigating heightened distress and a growing feeling of isolation.";
            case 11 ->
                    "Dim corridors cast shadows, evoking a sense of growing unease with an oppressive stillness and faint, unsettling sounds.";
            case 12 ->
                    "Twisting, dimly lit pathways reveal obscured areas and partial collapses, creating a claustrophobic atmosphere and increasing navigation challenges.";
            case 13 ->
                    "Chilling air and dim, flickering lights create a maze of eerie shadows and unsettling whispers in labyrinthine routes, amplifying a sense of urgency and unease.";
            case 14 ->
                    "Dimly lit routes cast ominous shadows and reveal whispers of ghostly echoes, enveloping the surroundings in an oppressive, chilling silence.";
            case 15 ->
                    "Darkness creeps through the almost impassable pathways, hinting at collapsed structures and hidden passages, amplifying a sense of desperation and isolation.";
            case 16 ->
                    "Darkness envelops the labyrinth, suffocating in an unsettling silence, instigating a sense of disorientation and escalating urgency.";
            case 17 ->
                    "Thick darkness shrouds the environment, fostering disorientation and intensifying a growing unease and sense of urgency.";
            case 18 ->
                    "Near-complete darkness instills vulnerability and a heightened urgency, forcing reliance on personal light sources.";
            case 19 ->
                    "The darkness is thick with dread and disorientation, evoking a pressing need to escape this disconcerting abyss.";
            case 20 ->
                    "The oppressive, disorienting environment enveloped in near-complete darkness prompts a growing sense of urgency and isolation.";
            default -> throw new IllegalStateException("Unexpected value: " + roll.d20());
        };
    }

    public String deeperFloors() {

        return switch (roll.d20()) {
            case 1 ->
                    "The oppressive, near-complete darkness invokes a sense of vulnerability and an ever-intensifying urgency to escape the disconcerting abyss.";
            case 2 ->
                    "The heavy, suffocating darkness fosters disorientation and a growing sense of desperation and isolation.";
            case 3 ->
                    "Surrounded by almost complete darkness, the environment is thick with dread and a growing unease and urgency.";
            case 4 -> "Darkness suffocates the labyrinth, evoking disorientation and escalating unease and urgency.";
            case 5 ->
                    "Near-complete darkness envelops the environment, fostering a sense of vulnerability and a heightened urgency to escape.";
            case 6 ->
                    "The thick darkness instills dread and disorientation, urging a pressing need to escape the disconcerting abyss.";
            case 7 ->
                    "Oppressive, near-complete darkness prompts a growing sense of urgency and isolation in an ever-encroaching disorienting environment.";
            case 8 ->
                    "The labyrinth is shrouded in thick darkness, fostering vulnerability and intensifying a growing unease and sense of urgency.";
            case 9 ->
                    "Thick darkness surrounds, instigating a sense of desperation and an ever-intensifying urgency to escape the disconcerting abyss.";
            case 10 ->
                    "Near-complete darkness fosters vulnerability and an escalating sense of disorientation and urgency.";
            case 11 ->
                    "The oppressive darkness is suffocating, intensifying a growing unease and the pressing urgency to escape.";
            case 12 -> "The thick, disorienting darkness instills a pressing need to flee the suffocating abyss.";
            case 13 ->
                    "Darkness is thick and oppressive, fostering vulnerability and an intensifying sense of desperation and urgency.";
            case 14 ->
                    "The heavy, disorienting darkness amplifies a sense of dread and an ever-encroaching need to escape.";
            case 15 ->
                    "The oppressive, near-complete darkness prompts an intensifying urgency and a growing sense of isolation.";
            case 16 ->
                    "Darkness grows suffocating and thick, evoking a pressing need to escape the disconcerting abyss.";
            case 17 -> "Thick, disorienting darkness intensifies a growing unease and a pressing urgency to escape.";
            case 18 ->
                    "Darkness is suffocating and thick, intensifying vulnerability and amplifying an urgent need to escape the disorienting, oppressive abyss.";
            case 19 ->
                    "The oppressive, thick darkness prompts a growing sense of urgency and a pressing need for escape.";
            case 20 ->
                    "The labyrinth is shrouded in suffocating darkness, fostering a growing unease and an ever-encroaching urgency to escape.";
            default -> throw new IllegalStateException("Unexpected value: " + roll.d20());
        };
    }


    // GET n SET
    public DiceSet getRoll() {
        return roll;
    }

    public void setRoll(DiceSet roll) {
        this.roll = roll;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public boolean isHasStore() {
        return hasStore;
    }

    public void setHasStore(boolean hasStore) {
        this.hasStore = hasStore;
    }

    public boolean isHasTreasure() {
        return hasTreasure;
    }

    public void setHasTreasure(boolean hasTreasure) {
        this.hasTreasure = hasTreasure;
    }

    public boolean isHasMonster() {
        return hasMonster;
    }

    public void setHasMonster(boolean hasMonster) {
        this.hasMonster = hasMonster;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public MenuTool getMenu() {
        return menu;
    }

    public void setMenu(MenuTool menu) {
        this.menu = menu;
    }
}
