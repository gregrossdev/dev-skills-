package hackerrank.algorithms.subdomains.s02_implementation;

import java.util.List;

public class Q26E_TheHurdleRace {
    public static int hurdleRace(int k, List<Integer> height) {
        // How many doses of the potion must the character take to be able to jump all of the hurdles.
        // max number in list - max jump
        int max = 0;
        for (int maxHeight : height)
            if(maxHeight > max) max = maxHeight;

        int potions = max - k;
        if(potions > 0) return potions;
        else return 0;
    }
}
