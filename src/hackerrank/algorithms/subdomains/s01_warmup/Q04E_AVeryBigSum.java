package hackerrank.algorithms.subdomains.s01_warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Q04E_AVeryBigSum {
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

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Long> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long result = aVeryBigSum(ar);

        System.out.println(result);
    }
}
