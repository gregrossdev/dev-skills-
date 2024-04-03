package hackerrank.algorithms.subdomains.s01_warmup;
import java.util.Scanner;

public class Q01E_SolveMeFirst {
    static int solveMeFirst(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number ");
        int a;
        a = in.nextInt();
        System.out.println("Enter number ");
        int b;
        b = in.nextInt();
        int sum;
        sum = solveMeFirst(a, b);
        System.out.println("Solve Me First");
        System.out.println(sum);
    }
}
