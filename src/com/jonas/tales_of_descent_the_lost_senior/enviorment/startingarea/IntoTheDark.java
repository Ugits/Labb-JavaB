package com.jonas.tales_of_descent_the_lost_senior.enviorment.startingarea;

import com.jonas.tales_of_descent_the_lost_senior.enviorment.Scene;
import com.jonas.tales_of_descent_the_lost_senior.player.Player;


public class IntoTheDark extends Scene {

    public IntoTheDark(Player player) {
        super(player, -1, -1);
        setDescription(intoTheDarkDescription(player));
        description();
        part1();
    }

    @Override
    public void description() {
        getOut().printHeader(getOut().sceneHead);
        getOut().printScene(getDescription());
    }


    public String intoTheDarkDescription(Player player) {
        return YELLOW_ITALIC + player.getHero().getName() + YELLOW_ITALIC + ", !!!!!!!!!!!!!!!!!!!!!!!" + RESET;
    }

    public void part1() {
        //Into The Dark
        /**
         * String intoTheDark = """
         You just came throughout the waterfall opening you eyes. You take a few steps,
         into the stripes of light that leaks from the cracked open ceiling.
         you see a trail of lit torches along the walls. Now theres no turning back.
         While flickering fire leads you down the hall, you suddenly notice an updraft wind, you stopped.
         Slowly, you look down, and there is nothing there. nothing but an endless fall to death.
         While thinking that you just consumed the last bit of luck, you see two poles sticking up by your feet.
         Trying to figure out how long a climb would be.
         The ladder is fading out while scooping down the darkness, you realize, its also the only option to get to were you need.

         So you descend, the wooden craft you climb feels pretty sturdy.
         As you emerge, you try to project comfort upon yourself by saying..
         "this ain't so bad..."
         but... *sniff* *sniff*
         what is that?...
         ... rotten meat?

         Reaching solid ground, you turn around..
         """;
         System.out.println(intoTheDark);
         */
        getOut().printNarrative("""
                You step through the waterfall's opening, blinking as your
                eyes adjust to the light filtering through the cracked ceiling.
                With a few cautious steps forward, you notice a trail of flickering torches
                lining the walls, illuminating a path that seems to beckon you further.
                                
                As you progress, following the faintly lit corridor,
                a sudden gust of wind halts you in your tracks.
                Peering down, a dizzying sight greets you..
                a seemingly endless chasm beneath your feet, a plunge into certain death.
                                
                Just as the weight of your predicament settles in,
                your eyes catch sight of two poles protruding from the ground near your feet,
                offering a glimmer of hope in the darkness.
                                
                Surveying the height and evaluating your options,
                you notice the faint outline of a ladder vanishing into the depths of the unknown.
                The ascent seems daunting, but you realize
                it's the only plausible route to your destination.
                                
                With cautious determination, you begin the descent,
                the wooden rungs offering a sense of security as you navigate downwards.
                Emerging from the ladder's descent, you attempt to reassure yourself, murmuring..""");

        getOut().br();
        getOut().printHeader(getPlayer().getHero().getName());
        getOut().delayPrint(30, "This isn't so bad...");
        getOut().br();

        getOut().printNarrative("""
                However, a pungent odor disrupts your fragile sense of comfort.
                You sniff the air, catching a whiff of something putrid and decayed
                the stench of rotten meat permeating the space.
                                        
                Setting foot on solid ground,
                you pivot around to investigate the source of the unpleasant smell...""");
    }
}
