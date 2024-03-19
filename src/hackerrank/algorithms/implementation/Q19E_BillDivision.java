package hackerrank.algorithms.implementation;

import java.util.List;

public class Q19E_BillDivision {
    public static void bonAppetit(List<Integer> bill, int k, int b) {
        // split the bill between anna and brian
        int total = 0;
        for (int idx = 0; idx < bill.size(); idx++) {
            if(idx != k) total += bill.get(idx);
        }

        int annaCost = total / 2;
        if (annaCost == b) System.out.println("Bon Appetit");
        else System.out.println(b - annaCost);

    }
}
