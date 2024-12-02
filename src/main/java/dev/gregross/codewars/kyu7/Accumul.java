package dev.gregross.codewars.kyu7;

public class Accumul {
	public static String accum(String s) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			result.append(Character.toUpperCase(ch)); // Add the first uppercase letter
			for (int j = 0; j < i; j++) {
				result.append(Character.toLowerCase(ch)); // Add the lowercase repeated letters
			}
			if (i < s.length() - 1) {
				result.append("-"); // Append dash unless it's the last group
			}
		}
		return result.toString();
	}
}