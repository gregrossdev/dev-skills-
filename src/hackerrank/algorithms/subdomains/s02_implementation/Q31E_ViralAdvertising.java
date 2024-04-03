package hackerrank.algorithms.subdomains.s02_implementation;

public class Q31E_ViralAdvertising {
    public static int viralAdvertising(int n) {
        // determine how many people have liked the ad by the end of a given day
        // shared with exactly 5 recipients per day
        int shared = 5;
        // liked ( recipients / 2 )
        int liked = (int) Math.floor(shared / 2.0);
        int cumulative = liked; // total likes

        for(int day = 2; day <= n; day++) {
            // ( recipients / 2 ) like and share with 3 friends on the following day
            shared = liked * 3;
            liked = (int) Math.floor(shared / 2.0);
            cumulative += liked;
        }

        return cumulative;

    }
}
