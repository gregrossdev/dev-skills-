package dev.gregross.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsogramTest {
	static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();

	public String randomString( int len ){
		StringBuilder sb = new StringBuilder( len );
		for( int i = 0; i < len; i++ )
			sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		return sb.toString();
	}

	@Test
	public void FixedTests() {
		assertEquals(true, Isogram.isIsogram("Dermatoglyphics"));
		assertEquals(true, Isogram.isIsogram("Isogram"));
		assertEquals(false, Isogram.isIsogram("moose"));
		assertEquals(false, Isogram.isIsogram("isIsogram"));
		assertEquals(false, Isogram.isIsogram("aba"));
		assertEquals(false, Isogram.isIsogram("moOse"));
		assertEquals(true, Isogram.isIsogram("thumbscrewjapingly"));
		assertEquals(true, Isogram.isIsogram(""));
	}

	private static boolean A(String str) {
		str = str.toLowerCase();
		int len = str.length();
		char arr[] = str.toCharArray();
		Arrays.sort(arr);
		for (int i = 0; i < len - 1; i++) {
			if (arr[i] == arr[i + 1])
				return false;
		}
		return true;
	}

	@Test
	public void RandomTests() {
		for(int i = 0; i < 101;) {
			String Z = randomString(++i * 10);
			assertEquals(A(Z), Isogram.isIsogram(Z));
		}
	}
}
