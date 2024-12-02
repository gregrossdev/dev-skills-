package dev.gregross.codewars.kyu7;

public class Vowels {

/*
	Return the number (count) of vowels in the given string.

	We will consider a, e, i, o, u as vowels for this Kata (but not y).

	The input string will only consist of lower case letters and/or spaces.

	Strings Fundamentals
 */

	public static int getCount(String str) {
		int count = 0;
		for (char ch: str.toCharArray()) {
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				count++;
			}
		}
		return count;
	}
}