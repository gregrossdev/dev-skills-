package hackerrank.algorithms.subdomains;

import java.util.List;

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
			if (Character.isUpperCase(letter)) count++;
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
			char letter = s.charAt(idx);
			// character or not
			if (Character.isLetter(letter)) {
				// uppercase or not
				char type = Character.isUpperCase(letter) ? 'A' : 'a';
				char encryptedLetter = (char) ((letter - type + k) % 26 + type);
				// int asciiValuePlusK = (int) letter + k;
				// char encryptedLetter = (char) asciiValuePlusK;
				encrypted += encryptedLetter;
			} else {
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
		if (s.length() < subSeq.length()) return result;
		// compare indices of both strings (2 pointers)
		int sIdx = 0;
		int subSeqIdx = 0;
		while (sIdx < s.length() && subSeqIdx < subSeq.length()) {
			// if subSeq char is in string move to the next index of subSeq
			if (subSeq.charAt(subSeqIdx) == s.charAt(sIdx)) subSeqIdx++;
			sIdx++;
		}

		// check if subSeq index value is equal to the length
		if (subSeqIdx == subSeq.length()) result = "YES";

		return result;
	}

	// 62. Pangrams
	public static String pangrams(String s) {
		// check if its a pangram meaning containing every letter of the alphabet
		String notPangram = "not pangram";
		// check if its over 26 characters
		if (s.length() < 26) return notPangram;
		// normalize string to lowercase
		s = s.toLowerCase();
		// check if the string contains all the letters of the alphabet
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		// loop to check indices of the alphabet to the string indices
		for (int idx = 0; idx < alphabet.length(); idx++) {
			// if char in alphabet not found (-1) in string return result
			if (s.indexOf(alphabet.charAt(idx)) == -1) return notPangram;
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

	// 64. Funny String
	public static String funnyString(String s) {
		// Initialize the result as "Not Funny"
		String result = "Not Funny";

		// Loop through the string, but stop one character before the end
		for (int i = 0; i < s.length() - 1; i++) {
			// Calculate the absolute difference in ASCII values between the current character and the next one
			char currentChar = s.charAt(i);
			char nextChar = s.charAt(i + 1);
			int sDiff = Math.abs(currentChar - nextChar);

			// Calculate the absolute difference in ASCII values between the current character and the next one,
			// but start from the end of the string and move towards the start
			char currentCharFromEnd = s.charAt(s.length() - 1 - i);
			char nextCharFromEnd = s.charAt(s.length() - 2 - i);
			int rDiff = Math.abs(currentCharFromEnd - nextCharFromEnd);

			// If the differences are not the same, return "Not Funny" immediately
			if (sDiff != rDiff) {
				return result;
			}
		}

		// If we've gone through the entire string and the differences have always been the same,
		// change the result to "Funny"
		result = "Funny";

		// Return the result
		return result;
	}

	// 65. Gemstones
	public static int gemstones(List<String> arr) {
		// display the number of types of gemstones in the collection
		int countTypes = 0;
		// check if the gemstone is in all the strings
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		// loop through the alphabet
		int idx = 0;
		while(idx < alphabet.length()) {
			// check if the gemstone is in all the strings
			boolean isGemstone = true;
			for (String rock : arr) {
				if (rock.indexOf(alphabet.charAt(idx)) == -1) {
					isGemstone = false;
					break;
				}
			}
			if (isGemstone) countTypes++;
			// next letter
			idx++;
		}

		return countTypes;

	}

	// 66. Alternating Characters
	public static int alternatingCharacters(String s) {
		// find the minimum number of required deletions so that there are no matching adjacent characters.
		int minDeletes = 0;
		// check if the string has adjacent characters
		for (int idx = 0; idx < s.length() - 1; idx++) {
			// if the characters are the same increment the minDeletes
			if (s.charAt(idx) == s.charAt(idx + 1)) minDeletes++;
		}

		return minDeletes;

	}

	/*  67. Beautiful Binary String
	 *  Count and print the minimum number of steps needed to make Alice see the string as beautiful.
   *  It is beautiful if it does not contain the substring "010"
	 */
	public static int beautifulBinaryString(String b) {
		int count = 0;
		// check for the substring "010" in the string
		for (int idx = 0; idx < b.length() - 2; idx++) {
			if (b.substring(idx, idx + 3).equals("010")) {
				// increment the count and move the index by 2
				count++;
				idx += 2;
			}
		}

		return count;

	}

	/*  68. The Love-Letter Mystery
	 *  Determine the minimum number of operations required to convert a given string into a palindrome.
	 *  Can only reduce the value of a letter by 1, so for ex. d -> c or c -> b
	 */
	public static int theLoveLetterMystery(String s) {
		// count minimum operations
		int minOperations = 0;
		// check for a palindrome in the string
		for (int idx = 0; idx < s.length() / 2; idx++) {
			// compare the characters from the start and end of the string
			char start = s.charAt(idx);
			char end = s.charAt(s.length() - 1 - idx);
			// find the difference in the characters by their ascii values
			minOperations += Math.abs(start - end);
		}

		return minOperations;

	}




}
