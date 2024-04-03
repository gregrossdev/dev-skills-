package hackerrank.algorithms.subdomains.s01_warmup;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Q03E_CompareTheTriplets {
    /*
     * Complete the 'compareTriplets' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

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

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Q03E_CompareTheTriplets.compareTriplets(a, b);

        System.out.println(result);

        bufferedReader.close();
    }

}
