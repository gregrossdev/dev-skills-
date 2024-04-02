package hackerrank.algorithms.implementation;

public class Q30E_BeautifulDaysAtTheMovies {
    public static int beautifulDays(int i, int j, int k) {
        int beautifulCount = 0;

        for (int day = i; day <= j; day++) {
            int reverse = reverse(day); // Get the reverse of the day
            int absoluteDifference = Math.abs(day - reverse); // Calculate the absolute difference

            if (absoluteDifference % k == 0) {
                beautifulCount++; // Increment the count if the absolute difference is divisible by k
            }
        }

        return beautifulCount;
    }

    static int reverse(int num) {
        int reversed = 0;
        while (num != 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }
}
