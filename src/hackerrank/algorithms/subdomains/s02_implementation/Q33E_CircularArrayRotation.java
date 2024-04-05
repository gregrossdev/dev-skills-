package hackerrank.algorithms.subdomains.s02_implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q33E_CircularArrayRotation {
    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        // perform a number of right circular rotations and return the values of the elements at the given indices
        List<Integer> results = new ArrayList<>();
        // rotated array
        int n = a.size();
        Integer[] rotatedArray = new Integer[n];
        for (int idx = 0; idx < n; idx++) {
            // rotate index by k rotations find updated index by finding remainder
            // (0 + 2) % 5 = 2
            // (1 + 2) % 5 = 3
            // (2 + 2) % 5 = 4
            // (3 + 2) % 5 = 0
            // (4 + 2) % 5 = 1
            int rIdx = (idx + k) % n;
            rotatedArray[rIdx] = a.get(idx);
        }

        List<Integer> rotatedList = Arrays.asList(rotatedArray);
        for (int queryIdx : queries) {
            results.add(rotatedList.get(queryIdx));
        }

        return results;

    }
}
