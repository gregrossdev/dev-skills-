package leetcode;

public class L75 {
    /*
     * Array / String
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

}
