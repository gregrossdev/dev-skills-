package hackerrank.algorithms.subdomains;

public class Strings {
    /*
     * Easy
     ******************/
    // 58. CamelCase
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

    // 59. Strong Password
    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        int valid = 4;
        String numbers = "0123456789";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialCharacters = "!@#$%^&*()-+";

        // Check each character in the password
        boolean containsNumber = false;
        boolean containsLowerCase = false;
        boolean containsUpperCase = false;
        boolean containsSpecialChar = false;

        for (char letter : password.toCharArray()) {
            if (numbers.contains(String.valueOf(letter))) {
                containsNumber = true;
            } else if (lowerCase.contains(String.valueOf(letter))) {
                containsLowerCase = true;
            } else if (upperCase.contains(String.valueOf(letter))) {
                containsUpperCase = true;
            } else if (specialCharacters.contains(String.valueOf(letter))) {
                containsSpecialChar = true;
            }
        }

        if (!containsNumber) {
            valid--;
        }

        if (!containsLowerCase) {
            valid--;
        }

        if (!containsUpperCase) {
            valid--;
        }

        if (!containsSpecialChar) {
            valid--;
        }

        // Check if the password is already at least 6 characters long
        if (n >= 6) {
            return 0; // No additional characters needed
        } else {
            return Math.max(6 - n, valid);
        }
    }

    // 60. Ceaser Cipher
    public static String caesarCipher(String s, int k) {
        String encrypted = "";
        // rotate letters by k factor
        for (int idx = 0; idx < s.length(); idx++) {
            // add k to each character
            char letter  = s.charAt(idx);
            // character or not
            if(Character.isLetter(letter)) {
                // uppercase or not
                char type = Character.isUpperCase(letter) ? 'A' : 'a';
                char encryptedLetter = (char) ((letter - type + k) % 26 + type);
                // int asciiValuePlusK = (int) letter + k;
                // char encryptedLetter = (char) asciiValuePlusK;
                encrypted += encryptedLetter;
            }
            else {
                encrypted += letter;
            }
        }
        // returns encrypted string

        System.out.println(encrypted);

        return encrypted;
    }

    // 61. HackerRank in a String!
    public static String hackerrankInString(String s) {
        // check if subsesquence is in string
        String result = "NO";
        String subSeq = "hackerrank";
        // check lengths
        if(s.length() < subSeq.length()) return result;
        // compare indices of both strings (2 pointers)
        int sIdx      = 0;
        int subSeqIdx = 0;
        while(sIdx < s.length() && subSeqIdx < subSeq.length()) {
            // if subSeq char is in string move to the next index of subSeq
            if(subSeq.charAt(subSeqIdx) == s.charAt(sIdx)) subSeqIdx++;
            sIdx++;
        }

        // check if subSeq index value is equal to the length
        if(subSeqIdx == subSeq.length()) result = "YES";

        return result;
    }

    // 62. Pangrams
    public static String pangrams(String s) {
        // check if its a pangram meaning containing every letter of the alphabet
        String notPangram = "not pangram";
        // check if its over 26 characters
        if(s.length() < 26) return notPangram;
        // normalize string to lowercase
        s = s.toLowerCase();
        // check if the string contains all the letters of the alphabet
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        // loop to check indices of the alphabet to the string indices
        for(int idx = 0; idx < alphabet.length(); idx++) {
            // if char in alphabet not found (-1) in string return result
            if(s.indexOf(alphabet.charAt(idx)) == -1) return notPangram;
        }



        return "pangram";
    }

    // 63. Separate the Numbers
    public static void separateNumbers(String s) {
        // check if the string can be split into a sequence of increasing numbers
        boolean foundBeautiful = false;
        long firstNumber = -1;

        // Iterate through the string to find a beautiful sequence
        for (int length = 1; length <= s.length() / 2; length++) {
            // Iterate through the string to find a beautiful sequence
            // We start with a length of 1 and go up to half of the string length
            // because we're looking for sequences that start with a number of at least 1 digit
            // and end with a number that's not longer than half of the string length.

            long num = Long.parseLong(s.substring(0, length));
            firstNumber = num;
            String beautifulString = Long.toString(num);

            // Generate the beautiful sequence based on the first number
            // We initialize the beautifulString with the first number and then
            // keep appending consecutive numbers until the length of beautifulString
            // becomes equal to the length of the input string.

            while (beautifulString.length() < s.length()) {
                num++;
                beautifulString += Long.toString(num);
            }

            // Check if the generated sequence matches the input string
            // If the generated beautifulString matches the input string,
            // then we have found a beautiful sequence.

            if (beautifulString.equals(s)) {
                foundBeautiful = true;
                break;
            }
        }

        // If the sequence is increasing, return "YES" followed by the first number
        if (foundBeautiful) System.out.println("YES " + firstNumber);
        else System.out.println("NO");

    }



}
