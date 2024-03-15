package hackerrank.algorithms.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Q05E_DiagonalDifference {

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


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = diagonalDifference(arr);

        System.out.println(result);
    }
}
