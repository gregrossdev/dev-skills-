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

}
