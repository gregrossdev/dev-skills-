package hackerrank.algorithms.subdomains.s03_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E03_CaesarCipher {
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

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();
        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = caesarCipher(s, k);

        System.out.println(result);

        bufferedReader.close();
    }
}
