package hackerrank.algorithms.subdomains.s02_implementation;

import java.io.*;

public class Q13E_NumberLineJumps {
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // check if both kangaroos end in the same location
        int kangaroo1 = x1;
        int kangaroo2 = x2;
        int maxJumps = 10000;
        int jumps = 0;
        while (jumps < maxJumps) {
            kangaroo1 += v1;
            kangaroo2 += v2;

            if(kangaroo1 == kangaroo2) return "YES";

            jumps++;
        }

        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);

        int v1 = Integer.parseInt(firstMultipleInput[1]);

        int x2 = Integer.parseInt(firstMultipleInput[2]);

        int v2 = Integer.parseInt(firstMultipleInput[3]);

        String result = kangaroo(x1, v1, x2, v2);

        System.out.println(result);

        bufferedReader.close();
    }
}
