package leetcode.studyplan.leetcode_75;

public class ArraysAndStrings {
    /*
     * Easy
     ******************/

    // 1768. Merge Strings Alternately
    public String mergeAlternately(String word1, String word2) {
        // Merge the strings by adding letters in alternating order, starting with word1
        String mergedString = "";
        // find min word length to prevent boundary error
        int minWordLength = word1.length();
        if(word2.length() < word1.length()) minWordLength = word2.length();
        for(int i = 0; i <= minWordLength - 1; i++) {
            mergedString += word1.charAt(i);
            mergedString += word2.charAt(i);
        }

        // append the additional letters onto the end of the merged string
        mergedString += word1.substring(minWordLength);
        mergedString += word2.substring(minWordLength);

        return mergedString;
    }

    // 1071. Greatest Common Divisor of Strings
    public String gcdOfStrings(String str1, String str2) {
        // # find the substring repeating characters that both strings share in common
        String gcdString = "";
        // ## add strings together to find reoccurring string pattern
        String pattern1 = str1 + str2;
        String pattern2 = str2 + str1;
        if(pattern1.equals(pattern2)) {
            // find gcd of 2 string lengths
            int gcd = findGCD(str1.length(), str2.length());
            // set the substring pattern
            gcdString = str1.substring(0, gcd);
        }

        return gcdString;
    }

    // euclidean algorithm to find gcd recursively
    private int findGCD(int a, int b) {
        if(b == 0) return a;
        return findGCD(b, a % b);
    }




}
