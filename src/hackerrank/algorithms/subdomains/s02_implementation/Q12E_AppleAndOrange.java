package hackerrank.algorithms.subdomains.s02_implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Q12E_AppleAndOrange {
    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        // find how many apples and oranges land within range of  (s - t) which is sams house
        int noOfApples  = 0;
        int noOfOranges = 0;

        // +d moved right, -d moved left
        // add each fruit distance to the position of the tree
        // apples
        for (int apple : apples) {
            int posDist = a + apple;
            if(posDist >= s && posDist <= t) noOfApples++;
        }

        // oranges
        for (int orange : oranges) {
            int posDist = b + orange;
            if(posDist >= s && posDist <= t) noOfOranges++;
        }

        System.out.println(noOfApples);
        System.out.println(noOfOranges);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int s = Integer.parseInt(firstMultipleInput[0]);

        int t = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int a = Integer.parseInt(secondMultipleInput[0]);

        int b = Integer.parseInt(secondMultipleInput[1]);

        String[] thirdMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(thirdMultipleInput[0]);

        int n = Integer.parseInt(thirdMultipleInput[1]);

        List<Integer> apples = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> oranges = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        countApplesAndOranges(s, t, a, b, apples, oranges);

        bufferedReader.close();
    }
}
