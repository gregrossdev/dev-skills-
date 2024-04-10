package hackerrank.algorithms.subdomains.s02_implementation;

public class Q36E_FindDigits {
    public static int findDigits(int n) {
        // Given an integer, for each digit that makes up the integer determine whether it is a divisor. Count the number of divisors occurring within the integer.
        int countDivisors = 0;
        // convert int to string to get values in an array
        String nStr = Integer.toString(n);
        for(int idx = 0; idx < nStr.length(); idx++) {
            int number = Character.getNumericValue(nStr.charAt(idx));
            if(number != 0 && n % number == 0) countDivisors++;
        }

        return countDivisors;
    }
}
