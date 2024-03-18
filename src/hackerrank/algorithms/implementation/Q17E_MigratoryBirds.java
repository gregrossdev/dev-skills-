package hackerrank.algorithms.implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q17E_MigratoryBirds {
    public static int migratoryBirds(List<Integer> arr) {
        // count elements in array
        // [2,2,3,4,4,5,5,5]
        // { 2:2, 3:1, 4:2, 5:3 }
        // return 5
        Map<Integer, Integer> count = new HashMap<>();

        // create count occurences object
        for (int birdId : arr) {
            count.put(birdId, count.getOrDefault(birdId, 0) + 1);
        }

        int bird = -1;
        int maxCount = 0;

        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            int birdType  = entry.getKey();
            int birdCount = entry.getValue();
            if (birdCount > maxCount || (birdCount == maxCount && birdType < bird)) {
                bird = birdType;
                maxCount = birdCount;
            }
        }


        // return element max count
        // if multiple elements have max count
        // return smallest id reference
        return bird;

    }
}
