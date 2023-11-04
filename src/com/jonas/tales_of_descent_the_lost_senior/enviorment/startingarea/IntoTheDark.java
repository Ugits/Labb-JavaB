package com.jonas.tales_of_descent_the_lost_senior.enviorment.startingarea;

import com.jonas.tales_of_descent_the_lost_senior.enviorment.Scene;
import com.jonas.tales_of_descent_the_lost_senior.player.Player;


public class IntoTheDark extends Scene {

    public IntoTheDark(Player player) throws InterruptedException {
        super(player, -1, -1);
        setDescription(intoTheDarkDescription(player));
        description();
        part1();
    }

    @Override
    public void description() throws InterruptedException {
        getConsole().printHeader(sceneHead);
        getConsole().printScene(getDescription());
    }


    public String intoTheDarkDescription(Player player) throws InterruptedException {
        return YELLOW_ITALIC + player.getHero().getName() + YELLOW_ITALIC + ", !!!!!!!!!!!!!!!!!!!!!!!" + RESET;
    }

    public void part1() {
        //Into The Dark
        String intoTheDark = """
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
    }
}
