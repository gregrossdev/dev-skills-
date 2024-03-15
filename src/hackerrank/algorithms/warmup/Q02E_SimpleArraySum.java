package hackerrank.algorithms.warmup;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Q02E_SimpleArraySum {
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

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = simpleArraySum(ar);

        bufferedReader.close();
        System.out.println(result);
    }

}
