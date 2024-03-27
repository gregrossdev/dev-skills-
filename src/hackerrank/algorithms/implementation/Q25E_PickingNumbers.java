package hackerrank.algorithms.implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q25E_PickingNumbers {

    public static int pickingNumbers(List<Integer> a) {
        Map<Integer, Integer> frequencyMap = new HashMap<>(); // Create a HashMap to store frequency of numbers

        // Count the frequency of each number in the array
        for (int num : a) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxCount = 0; // Maximum count of elements satisfying the condition

        // Iterate through the keys in the frequency map
        for (int key : frequencyMap.keySet()) {
            int count = frequencyMap.get(key); // Get the frequency of the current number
            if (frequencyMap.containsKey(key - 1)) {
                count += frequencyMap.get(key - 1); // Add the frequency of the previous number if present
            }
            maxCount = Math.max(maxCount, count); // Update maxCount with the maximum count found
        }

        return maxCount;
    }
}
