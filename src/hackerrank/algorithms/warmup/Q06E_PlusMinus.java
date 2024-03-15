package hackerrank.algorithms.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Q06E_PlusMinus {
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

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        plusMinus(arr);

    }


}
