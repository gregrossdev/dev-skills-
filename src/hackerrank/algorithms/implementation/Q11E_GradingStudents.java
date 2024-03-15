package hackerrank.algorithms.implementation;

import java.util.ArrayList;
import java.util.List;

public class Q11E_GradingStudents {
    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // round all the grades based off of the following policy
        // if less than 40 keep as is
        // subtract grade from next mulitple of 5
        // if less than 3 then round to next multiple of 5
        //  else remain the same
        // input:  [73,67,38,33]
        // output: [75,67,40,33]
        List<Integer> roundedGrades = new ArrayList<>();

        for (int grade : grades) {
            if(grade < 38 || grade % 5 < 3) roundedGrades.add(grade);
            else {
                int roundedGrade = (grade / 5 + 1) * 5;
                roundedGrades.add(roundedGrade);
            }
        }

        return roundedGrades;
    }
}
