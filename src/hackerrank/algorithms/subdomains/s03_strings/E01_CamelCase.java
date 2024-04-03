package hackerrank.algorithms.subdomains.s03_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E01_CamelCase {
    public static int camelcase(String s) {
        // determine the number of words in a camelCase string
        int count = 1;
        // count each uppercase letters + 1
        for (int idx = 0; idx < s.length(); idx++) {
            char letter = s.charAt(idx);
            if(Character.isUpperCase(letter)) count++;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        int result = camelcase(s);

        System.out.println(result);

        bufferedReader.close();
    }
}
