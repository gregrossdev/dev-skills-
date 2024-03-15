package hackerrank.algorithms.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q07E_Staircase {

    public static void staircase(int n) {
        // print a staircase of size n
        // staircase draws from rtl
        // n = height
        int height = n;
        for (int i = 1; i <= height; i++) {
            for(int j = 1; j <= height - i; j++){
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        staircase(n);
    }
}
