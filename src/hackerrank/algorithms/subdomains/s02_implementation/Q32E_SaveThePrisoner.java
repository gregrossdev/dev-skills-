package hackerrank.algorithms.subdomains.s02_implementation;

public class Q32E_SaveThePrisoner {

    public static int saveThePrisoner(int n, int m, int s) {
        // Find chair number that last candy is distributed to
        // s = startingChair
        // n = numberOfPrisoners
        // m = numberOfSweets

        // Calculate the chair number in a circular manner
        int chair = (s + m - 1) % n;

        // Handle the edge case when chair number is 0 (last chair)
        if (chair == 0) {
            chair = n; // Set to the last chair
        }

        // Return the chair number of the last prisoner to receive candy
        return chair;
    }
}
