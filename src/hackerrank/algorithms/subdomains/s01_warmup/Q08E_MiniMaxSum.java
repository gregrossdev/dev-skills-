package hackerrank.algorithms.subdomains.s01_warmup;

import java.util.List;

public class Q08E_MiniMaxSum {

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
}
