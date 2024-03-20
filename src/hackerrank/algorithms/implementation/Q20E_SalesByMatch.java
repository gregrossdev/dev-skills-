package hackerrank.algorithms.implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q20E_SalesByMatch {
    public static int sockMerchant(int n, List<Integer> ar) {
        // count socks that do not have pairs
        int count = 0;
        // {1:3, 2:3, 3:1}
        Map<Integer, Integer> socks = new HashMap<>();
        for(int idx = 0; idx < ar.size(); idx++)
            socks.put(ar.get(idx), socks.getOrDefault(ar.get(idx), 0) + 1);

        for (Map.Entry<Integer, Integer> entry : socks.entrySet())
            count += entry.getValue() / 2;

        return count;
    }
}
