package hackerrank.algorithms.warmup;

import java.util.List;

public class Q09E_BirthdayCakeCandles {
    public static int birthdayCakeCandles(List<Integer> candles) {
        // count the tallest candles
        // input: [3,2,1,3]
        // output: 2
        int howMany = 0;
        int max = Integer.MIN_VALUE;

        for (Integer candle : candles) {
            // find the tallest
            if(candle > max) {
                max = candle;
                howMany = 1;
            }
            // count how many
            else if(candle == max) howMany++;
        }


        return howMany;
    }
}
