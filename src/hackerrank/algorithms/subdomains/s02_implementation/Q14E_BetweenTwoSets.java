package hackerrank.algorithms.subdomains.s02_implementation;

import java.util.List;

public class Q14E_BetweenTwoSets {

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int lcmA = lcmOfArray(a);
        int gcdB = gcdOfArray(b);

        int count = 0;
        for (int i = lcmA, j = 2; i <= gcdB; i = lcmA * j, j++) {
            if (gcdB % i == 0) {
                count++;
            }
        }

        return count;
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    static int lcmOfArray(List<Integer> arr) {
        int result = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            result = lcm(result, arr.get(i));
        }
        return result;
    }

    static int gcdOfArray(List<Integer> arr) {
        int result = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            result = gcd(result, arr.get(i));
        }
        return result;
    }

}
