package hackerrank.algorithms.implementation;

import java.util.ArrayList;
import java.util.List;

public class Q15E_BreakingTheRecords {
    public static List<Integer> breakingRecords(List<Integer> scores) {
        // count number of games either max or min points were scored
        List<Integer> records = new ArrayList<>();

        int maxCount = 0;
        int minCount = 0;
        int maxScore = scores.get(0);
        int minScore = scores.get(0);

        for (int score : scores) {
            if(score < minScore) {
                minScore = score;
                minCount++;
            }
            if(score > maxScore) {
                maxScore = score;
                maxCount++;
            }
        }

        records.add(maxCount);
        records.add(minCount);

        return records;
    }
}
