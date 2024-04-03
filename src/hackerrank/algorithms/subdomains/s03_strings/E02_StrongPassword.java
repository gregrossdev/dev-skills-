package hackerrank.algorithms.subdomains.s03_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E02_StrongPassword {

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

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = minimumNumber(n, password);

        System.out.println(answer);

        bufferedReader.close();
    }
}
