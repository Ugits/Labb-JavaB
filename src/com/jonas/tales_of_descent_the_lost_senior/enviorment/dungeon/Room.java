package com.jonas.tales_of_descent_the_lost_senior.enviorment.dungeon;

import com.jonas.tales_of_descent_the_lost_senior.Game;
import com.jonas.tales_of_descent_the_lost_senior.characters.Character;
import com.jonas.tales_of_descent_the_lost_senior.characters.monster.models.Goblin;
import com.jonas.tales_of_descent_the_lost_senior.characters.monster.Monster;
import com.jonas.tales_of_descent_the_lost_senior.characters.monster.models.NoMonster;
import com.jonas.tales_of_descent_the_lost_senior.characters.monster.models.PackOfRats;
import com.jonas.tales_of_descent_the_lost_senior.enviorment.Scene;
import com.jonas.tales_of_descent_the_lost_senior.interaction.DiceSet;
import com.jonas.tales_of_descent_the_lost_senior.resources.MenuTool;

public class Room extends Scene {
    DiceSet roll = new DiceSet();
    MenuTool menu;

    private int difficulty;
    private int floorNum;
    private int roomNum;
    private boolean hasStore;
    private boolean hasTreasure;
    private boolean hasMonster;
    private Character monster;
    private Character hero;
    public boolean actionMenuActive;
    public boolean combatMenuActive;
    public boolean beenHereBefore;

    public Room(Character hero, int floorNum, int roomNum, Game game) {
        super(game);
        this.hero = hero;
        this.difficulty = floorNum;
        this.floorNum = floorNum;
        this.roomNum = roomNum;


        if (getHero().isFirstTimeInDungeon()) {
            this.monster = new PackOfRats(floorNum);
            setHasMonster(true);
            setDescription("Investigating the foul smell, you discover rats devouring a corpse. \n As you approach, the vermin abruptly turn their attention toward you, hissing in an unnerving standoff.");
            getHero().setFirstTimeInDungeon(false);
        } else {
            setHasMonster(false);
            this.monster = (roll.d20() > 10) ? fetchMonster(roll.dCustom(2)) : new NoMonster(); // Abstract clas cant be null?
            setDescription(genDescription());
        }

        // has store todo implement store
        // has tressure todo modify with LUCK //

        this.hasTreasure = roll.d20() > 16;

        // set description

        setMenu(new MenuTool(this, game));
    }

    @Override
    public void runScene() {

        getOut().printHeader("Room " + getRoomNum() + RESET + YELLOW_BOLD + " -- " + YELLOW_ITALIC + "Floor " + getFloorNum());
        getOut().br();
        if (!beenHereBefore) {
            getOut().printScene(getDescription());
            getOut().br();
            beenHereBefore = true;
        }
    }

    public void checkIfMonster() {

        if (hasMonster || !getHero().isDead()) {
            monsterEncounter();
        }
    }

    public void runHeroAction() {

        actionMenuActive = true;
        while (actionMenuActive) {
            getMenu().actionMenu();
        }
    }

    private void monsterEncounter() {
        if(hasMonster){
            getOut().printMonster(getMonster());
        }

        getHero().setAttacking(true);
        while (!getMonster().isDead() && !getHero().isDead()) {

            getMenu().combatMenu();

            if (!getMonster().isDead() && !getHero().isAttacking() && !getHero().isDead()) {
                getMonster().attack(getHero(), getMenu().getGame());
            }
            if (getMonster().isDead()) {
                setHasMonster(false);
            }

        }
    }

    public Monster fetchMonster(int roll) {
        this.hasMonster = true;
        Monster temp = null;
        switch (roll) {
            case 1 -> temp = new PackOfRats(getFloorNum());
            case 2 -> temp = new Goblin(getFloorNum());
            default -> System.out.println("check random number in fetch Monster");
        }
        return temp;
    }

    public String genDescription() {

        return switch (getFloorNum()) {
            case 1 -> shallowFloors();
            case 2, 3, 4 -> midDepthFloors();
            case 5 -> deeperFloors();
            default -> throw new IllegalStateException("Unexpected value: " + roll.d20());
        };
    }

    public String shallowFloors() {

        return switch (roll.d20()) {
            case 1 ->
                    "The corridors, softly lit by scattered torches, reveal murals depicting forgotten tales \nof heroic deeds and past glory, instilling a sense of hope and exploration.";
            case 2 ->
                    "Within a chamber, a faint glow permeates through cracks in the ceiling, \ncasting a gentle light on ancient artifacts, lending a sense of quiet wonder and a hint of distant sunlight.";
            case 3 ->
                    "Meandering through well-maintained pathways reveals remnants of a forgotten era, \noffering a welcoming ambiance with the air carrying a hint of an earthy fragrance.";
            case 4 ->
                    "A spacious room unveils clear paths among weathered architecture, inviting a sense of \nhistorical reverence tinged with the echoes of distant stories and a whisper of forgotten voices.";
            case 5 ->
                    "The well-preserved corridors create a sense of tranquility and openness, \nhinting at former grandeur now overrun by nature, fostering a contemplative and serene mood.";
            case 6 ->
                    "Sunlight softly filters through the chamber, illuminating the worn yet elegant structures, \nhinting at the beauty of the past and offering a tranquil, exploratory ambiance.";
            case 7 ->
                    "A well-lit passageway hints at a comforting sense of safety, \nwith remnants of previous explorers paving the way, fostering a curious and cautious atmosphere.";
            case 8 ->
                    "Dim light reveals scattered remnants of bygone eras, granting a glimpse \nof the past's opulence now long forgotten, evoking a mixture of awe and contemplation.";
            case 9 ->
                    "Gentle illumination in the corridors exposes forgotten relics and hints of a lost age, \noffering an almost serene yet inviting environment that invites curiosity and contemplation.";
            case 10 ->
                    "Softly glowing passages suggest ancient beauty amidst decay, \ncreating an atmosphere that is welcoming and rich with a quiet sense of historical significance.";
            case 11 ->
                    "Faint sunlight seeps through cracks above, offering a glimpse of a tranquil outside world within the space, \ninstilling a sense of reassurance and an inviting exploratory mood.";
            case 12 ->
                    "Meandering through softly lit corridors unveils forgotten relics and architectural remnants, \nradiating a sense of forgotten beauty and sparking curiosity and contemplation.";
            case 13 ->
                    "Softly lit paths hint at aged remnants of past grandeur, \noffering a historical significance that invites both contemplation and cautious exploration.";
            case 14 ->
                    "The well-lit surroundings reveal a wealth of historical significance, \nwith ancient artifacts hinting at past prosperity, creating an environment rich in both curiosity and caution.";
            case 15 ->
                    "A chamber softly illuminated by scattered torchlight presents aged structures and echoes of history, \noffering an environment that is both contemplative and welcoming.";
            case 16 ->
                    "Soft illumination reveals remnants of a forgotten era, \nradiating a sense of historical importance that encourages both curiosity and caution.";
            case 17 ->
                    "Faint light filtering through cracks paints a tranquil scene within the space, \nsuggesting a comforting yet exploratory atmosphere.";
            case 18 ->
                    "Within the softly lit chambers, forgotten relics and remnants of ancient architecture suggest \na serene yet engaging environment rich with historical significance.";
            case 19 ->
                    "Softly glowing corridors invite exploration amid ancient beauty amidst decay, \ncreating an inviting atmosphere rich with contemplation and curiosity.";
            case 20 ->
                    "Scattered torches light the corridors, uncovering murals and aged remnants, \noffering a sense of historical significance and a mood conducive to exploration and curiosity.";
            default -> throw new IllegalStateException("Unexpected value: " + roll.d20());
        };
    }

    public String midDepthFloors() {

        return switch (roll.d20()) {
            case 1 ->
                    "Dimly lit passageways reveal obscured areas and partially collapsed walls, \npresenting challenges in navigation, fostering a growing sense of claustrophobia and unease.";
            case 2 ->
                    "Debris-strewn corridors and faint light cast shadows and whispers of ghostly echoes, \nenveloping the surroundings in a chilling stillness and a foreboding ambiance.";
            case 3 ->
                    "The dimly lit pathways twist into labyrinthine routes, the air growing colder and \nthe silence becoming more ominous, amplifying a sense of urgency and unease.";
            case 4 ->
                    "Shadows and debris obscure the dimly lit routes, \noffering a menacing ambiance with whispers of ghostly echoes and unsettling, faint sounds.";
            case 5 ->
                    "The oppressive silence hangs heavily in darkened corridors, \nthe surroundings twisting into obscure paths that amplify confusion and unease.";
            case 6 ->
                    "Dim, flickering light casts eerie shadows and faint echoes within labyrinthine routes, \ninstilling a sense of foreboding and urgency.";
            case 7 ->
                    "As light dims, the surroundings become menacing, and cold drafts and ominous echoes pervade the space, \nevoking a sense of disquiet and urgency.";
            case 8 ->
                    "The oppressive silence grows in almost impassable pathways, \nrevealing collapsed structures and hidden passages that amplify a sense of desperation and isolation.";
            case 9 ->
                    "Almost imperceptible light engulfs the environment, \nthick with an unsettling silence and an ever-growing sense of disorientation and urgency.";
            case 10 ->
                    "Obscure and menacing routes become disorienting and foreboding, \ninstigating heightened distress and a growing feeling of isolation.";
            case 11 ->
                    "Dim corridors cast shadows, evoking a sense of growing unease \nwith an oppressive stillness and faint, unsettling sounds.";
            case 12 ->
                    "Twisting, dimly lit pathways reveal obscured areas and partial collapses, \ncreating a claustrophobic atmosphere and increasing navigation challenges.";
            case 13 ->
                    "Chilling air and dim, flickering lights create a maze of eerie shadows and \nunsettling whispers in labyrinthine routes, amplifying a sense of urgency and unease.";
            case 14 ->
                    "Dimly lit routes cast ominous shadows and reveal whispers of ghostly echoes, \nenveloping the surroundings in an oppressive, chilling silence.";
            case 15 ->
                    "Darkness creeps through the almost impassable pathways, \nhinting at collapsed structures and hidden passages, amplifying a sense of desperation and isolation.";
            case 16 ->
                    "Darkness envelops the labyrinth, suffocating in an unsettling silence, \ninstigating a sense of disorientation and escalating urgency.";
            case 17 ->
                    "Thick darkness shrouds the environment, \nfostering disorientation and intensifying a growing unease and sense of urgency.";
            case 18 ->
                    "Near-complete darkness instills vulnerability and a heightened urgency, \nforcing reliance on personal light sources.";
            case 19 ->
                    "The darkness is thick with dread and disorientation, \nevoking a pressing need to escape this disconcerting abyss.";
            case 20 ->
                    "The oppressive, disorienting environment enveloped in \nnear-complete darkness prompts a growing sense of urgency and isolation.";
            default -> throw new IllegalStateException("Unexpected value: " + roll.d20());
        };
    }

    public String deeperFloors() {

        return switch (roll.d20()) {
            case 1 ->
                    "The oppressive, near-complete darkness invokes a sense of vulnerability and \nan ever-intensifying urgency to escape the disconcerting abyss.";
            case 2 ->
                    "The heavy, suffocating darkness fosters disorientation and a growing sense of \ndesperation and isolation.";
            case 3 ->
                    "Surrounded by almost complete darkness, \nthe environment is thick with dread and a growing unease and urgency.";
            case 4 -> "Darkness suffocates the labyrinth, \nevoking disorientation and escalating unease and urgency.";
            case 5 ->
                    "Near-complete darkness envelops the environment, \nfostering a sense of vulnerability and a heightened urgency to escape.";
            case 6 ->
                    "The thick darkness instills dread and disorientation, \nurging a pressing need to escape the disconcerting abyss.";
            case 7 ->
                    "Oppressive, near-complete darkness prompts a growing sense of urgency and \nisolation in an ever-encroaching disorienting environment.";
            case 8 ->
                    "The labyrinth is shrouded in thick darkness, \nfostering vulnerability and intensifying a growing unease and sense of urgency.";
            case 9 ->
                    "Thick darkness surrounds, instigating a sense of desperation and \nan ever-intensifying urgency to escape the disconcerting abyss.";
            case 10 ->
                    "Near-complete darkness fosters vulnerability and \nan escalating sense of disorientation and urgency.";
            case 11 ->
                    "The oppressive darkness is suffocating, \nintensifying a growing unease and the pressing urgency to escape.";
            case 12 -> "The thick, disorienting darkness instills a pressing need to flee the suffocating abyss.";
            case 13 ->
                    "Darkness is thick and oppressive, \nfostering vulnerability and an intensifying sense of desperation and urgency.";
            case 14 ->
                    "The heavy, disorienting darkness amplifies a sense of dread and \nan ever-encroaching need to escape.";
            case 15 ->
                    "The oppressive, near-complete darkness prompts an intensifying urgency \nand a growing sense of isolation.";
            case 16 ->
                    "Darkness grows suffocating and thick, \nevoking a pressing need to escape the disconcerting abyss.";
            case 17 -> "Thick, disorienting darkness intensifies a growing unease and a pressing urgency to escape.";
            case 18 ->
                    "Darkness is suffocating and thick, intensifying vulnerability and \namplifying an urgent need to escape the disorienting, oppressive abyss.";
            case 19 ->
                    "The oppressive, thick darkness prompts a growing sense of urgency and a pressing need for escape.";
            case 20 ->
                    "The labyrinth is shrouded in suffocating darkness, \nfostering a growing unease and an ever-encroaching urgency to escape.";
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


    public int getRoomNum() {
        return roomNum;
    }

    public MenuTool getMenu() {
        return menu;
    }

    public void setMenu(MenuTool menu) {
        this.menu = menu;
    }

    public void setMonster(Character monster) {
        this.monster = monster;
    }

    public Character getMonster() {
        return monster;
    }

    public Character getHero() {
        return hero;
    }

    public void setHero(Character hero) {
        this.hero = hero;
    }

    public boolean isActionMenuActive() {
        return actionMenuActive;
    }

    public void setActionMenuActive(boolean actionMenuActive) {
        this.actionMenuActive = actionMenuActive;
    }

    public boolean isCombatMenuActive() {
        return combatMenuActive;
    }

    public void setCombatMenuActive(boolean combatMenuActive) {
        this.combatMenuActive = combatMenuActive;
    }
}
