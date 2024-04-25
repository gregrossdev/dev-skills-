package hackerrank.algorithms.subdomains;

import java.util.ArrayList;
import java.util.List;

public class Warmup {
    /*
     * Easy
     ******************/

    // 01. Solve Me First
    public static int solveMeFirst(int a, int b) {
        // Hint: Type return a+b; below
        return a + b;
    }

    // 02. Simple Array Sum
    public static int simpleArraySum(List<Integer> ar) {
        // find the sum by adding all elements
        int sum = 0;
        // input: [1,2,3,4,10,11]
        // output: 33
        // example: 1 + 2 + 3 + 4 + 10 + 11 = 33
        // for each integer from list, add to sum
        for (Integer num : ar) {
            // 33 = 1 + 2 + 3 + 4 + 10 + 11
            sum += num;
        }

        // return 33;
        return sum;
    }

    // 03. Compare the Triplets
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        // compare each list item index
        // input: a = [5, 6, 7], b = [3, 6, 10]
        // output: [1, 1]
        List<Integer> score = new ArrayList<>();
        int aliceScore = 0;
        int bobScore   = 0;
        // if a[index] > b[index] alice scores a point
        // if a[index] < b[index] bob scores a point
        // if a[index] = b[index] neither scores a point
        for (int idx = 0; idx < a.size(); idx++) {
            int alice = a.get(idx);
            int bob  = b.get(idx);
            if(alice > bob) aliceScore++;
            if(alice < bob) bobScore++;
        }

        score.add(aliceScore);
        score.add(bobScore);
        // return [aliceScore, bobScore]

        return score;
    }

    // 04. A Very Big Sum
    public static long aVeryBigSum(List<Long> ar) {
        // calculate and print sum of elements in array
        // input: [1000000001, 1000000002, 1000000003, 1000000004, 1000000005]
        // output: 5000000015
        long sum = 0;
        // sum each long value in array
        for (Long value: ar) {
            sum += value;
        }

        // return sum of elements
        return sum;
    }

    // 05. Diagonal Difference
    public static int diagonalDifference(List<List<Integer>> arr) {
        // calculate the absolute difference between the sums of its diagonals
        // input: [[11, 2,   4],
        //         [04, 5,   6],
        //         [10, 8, -12]]
        // output: 15
        int ltr = 0;
        int rtl = 0;
        int n = arr.size();
        for (int idx = 0; idx < arr.size(); idx++) {
            // ltr diagonal ltr = 11 + 5 + -12
            // ltr = [ltr[0] + ltr[1] + ltr[2]]
            // ltr = 04
            ltr += arr.get(idx).get(idx);
            // rtl diagonal rtl =  4 + 5 + 10
            // rtl = [rtl[2] + rtl[1] + rtl[0]]
            // rtl = 19
            // (3 - 1) - 0 = 2
            // (3 - 1) - 1 = 1
            // (3 - 1) - 2 = 0
            rtl += arr.get(idx).get((n - 1) - idx);

            // rtl += arr.get(idx).get(Math.abs(idx - (n - 1)));

        }

        // return absolute difference from ltr to rtl
        // 04 - 19 = -15
        // absolute diff = 15
        return Math.abs(ltr - rtl);

    }

    // 06. Plus Minus
    public static void plusMinus(List<Integer> arr) {
        // calculate the ratios of its elements that are positive, negative, and zero.
        // input: [-4, 3, -9, 0, 4, 1]
        // output:
        //----------
        // postive values / number of values
        // System.out.println(0.500000)
        // negative values / number of values
        // System.out.println(0.333333)
        // zero values / number of values
        // System.out.println(0.166667)
        //--------------------------------------------------
        int totalValues = arr.size();
        double positiveValues = 0;
        double negativeValues = 0;
        double zeroValues     = 0;

        for (int idx = 0; idx < totalValues; idx++) {
            int value = arr.get(idx);
            if(value > 0) positiveValues++;
            else if (value < 0) negativeValues++;
            else zeroValues++;
        }

        System.out.println(String.format("%.6f", positiveValues/totalValues));
        System.out.println(String.format("%.6f", negativeValues/totalValues));
        System.out.println(String.format("%.6f",     zeroValues/totalValues));

    }

    // 07. Staircase
    public static void staircase(int n) {
        // print a staircase of size n
        // staircase draws from rtl
        // n = height
        int height = n;
        for (int i = 1; i <= height; i++) {
            for(int j = 1; j <= height - i; j++){
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

    }

    // 08. Mini-Max Sum
    public static void miniMaxSum(List<Integer> arr) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        long totalSum = 0;

        for (int i = 0; i < arr.size(); i++) {
            int currentNumber = arr.get(i);

            totalSum += currentNumber;

            if (currentNumber > max) {
                max = currentNumber;
            }

            if (currentNumber < min) {
                min = currentNumber;
            }
        }

        long minSum = totalSum - max;
        long maxSum = totalSum - min;

        System.out.println(minSum + " " + maxSum);
    }

    // 09. Birthday Cake Candles
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

    // 10. Time Conversion
    public static String timeConversion(String s) {
        String timeOfDay = s.substring(s.length() - 2);
        String formattedTime;

        if (timeOfDay.equals("PM")) {
            int hour = Integer.parseInt(s.substring(0, 2));
            formattedTime = (hour == 12) ? s.substring(0, 8) : String.format("%02d%s", hour + 12, s.substring(2, 8));
        } else {
            int hour = Integer.parseInt(s.substring(0, 2));
            formattedTime = (hour == 12) ? String.format("%02d%s", 0, s.substring(2, 8)) : s.substring(0, 8);
        }

        return formattedTime;
    }
}
