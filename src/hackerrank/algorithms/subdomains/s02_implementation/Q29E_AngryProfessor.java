package hackerrank.algorithms.subdomains.s02_implementation;

import java.util.List;

public class Q29E_AngryProfessor {
    public static String angryProfessor(int k, List<Integer> a) {
        // determine if the class is cancelled
        // if greater than k (threshold)
        String cancelledClass = "";
        int inClassCount = 0;
        for(int student: a) {
            if(student <= 0) inClassCount++;
        }

        if(inClassCount >= k) cancelledClass = "NO";
        else cancelledClass = "YES";

        return cancelledClass;
    }
}
