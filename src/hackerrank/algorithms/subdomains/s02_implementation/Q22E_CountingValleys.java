package hackerrank.algorithms.subdomains.s02_implementation;

public class Q22E_CountingValleys {
    public static int countingValleys(int steps, String path) {
        // count the number of valleys walked through.
        int count = 0;

        int seaLevel = 0;
        boolean inValley = false;

        char[] charArray = path.toCharArray();
        for(char letter: charArray) {
            if(letter == 'U') seaLevel++;
            else if(letter == 'D') seaLevel--;

            if(seaLevel == 0) {
                if(inValley) count++;
                inValley = false;
            }
            else if(seaLevel < 0) inValley = true;
        }


        return count;
    }
}
