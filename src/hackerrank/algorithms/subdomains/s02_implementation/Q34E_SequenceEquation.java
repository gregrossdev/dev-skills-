package hackerrank.algorithms.subdomains.s02_implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q34E_SequenceEquation {
    public static List<Integer> permutationEquation(List<Integer> p) {
        // find any integer  such that p(p(y)) = x and keep a history of the values of  in a return array
        List<Integer> result = new ArrayList<>();

        // Create a map to store the index of each element
        Map<Integer, Integer> map = new HashMap<>();

        // Populate the map with the index of each element
        for (int i = 0; i < p.size(); i++) {
            map.put(p.get(i), i + 1); // Add 1 to convert to 1-based index
        }

        // Step 3: Iterate over the sequence
        for (int y = 1; y <= p.size(); y++) {
            // Find the index of y in the sequence
            int i = map.get(y);

            // Find the index of i in the sequence to get p(p(y))
            int j = map.get(i);

            // Step 5: Add p(p(y)) to the result list
            result.add(j);
        }

        // Step 6: Return the list of values
        return result;
    }
}
