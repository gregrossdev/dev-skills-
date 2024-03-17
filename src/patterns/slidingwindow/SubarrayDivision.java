package patterns.slidingwindow;

import java.util.List;

/*
  Learn how to implement the algorithm of sliding window. This is a great example.
 */

public class SubarrayDivision {
    public static int birthday(List<Integer> s, int d, int m) {
        // count how many segments are possible
        int count = 0;
        // target value is d (rons birthdate)
        int sum = 0;
        // number of values possible is m (rons birth month)
        // Initialize the sliding window
        for (int i = 0; i < m; i++) {
            sum += s.get(i);
        }

        // Check the first window
        if (sum == d) {
            count++;
        }

        // Move the window and check subsequent subarrays
        for (int i = m; i < s.size(); i++) {
            sum += s.get(i) - s.get(i - m); // Slide the window by adding the next element and removing the first element

            // Check if the sum equals the target
            if (sum == d) {
                count++;
            }
        }

        return count;
    }
}
