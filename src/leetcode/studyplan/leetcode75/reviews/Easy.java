package leetcode.studyplan.leetcode75.reviews;

import java.util.ArrayList;
import java.util.List;

public class Easy {
	 /*  Array / String
	  ***********************************************************
		*  1768. Merge Strings Alternately
		*  1071. Greatest Common Divisor of Strings
		*  1431. Kids With the Greatest Number of Candies
		*  605. Can Place Flowers
		*  345. Reverse Vowels of a String
	  ***********************************************************/
	 /** 1768. Merge Strings Alternately
	 * https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75
	 */
	 // add letters in alternating order, starting with word1
	 // if a word is longer, append onto end of merged string
	 public String mergeAlternately(String word1, String word2) {
		 String mergedStr = "";
		 // find min length for looping
		 int minL = 0;
		 if(word1.length() < word2.length()) minL = word1.length();
		 else minL = word2.length();
		 // loop
		 for (int idx = 0; idx < minL; idx++) {
			 // add characters to mergedStr, starting with word1
			 mergedStr += word1.charAt(idx);
			 mergedStr += word2.charAt(idx);
		 }

		 // append remaining characters to mergedStr
		 mergedStr += word1.substring(minL);
		 mergedStr += word2.substring(minL);

		 return mergedStr;
	 }

	 /** 1071. Greatest Common Divisor of Strings
	 * https://leetcode.com/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75
	 */
	 // find gcd of two strings
	 public String gcdOfStrings(String str1, String str2) {
		 String gcdStr = "";
		 // variables for repetitive uses (3 or more)
		 int str1L = str1.length();

		 // find min length for comparing characters of both strings
		 int minL = 0;
		 if(str1L < str2.length()) minL = str1L;
		 else minL = str2.length();
		 // loop for comparing characters
		 char letter = '\u0000';
		 for(int idx = 0; idx < minL; idx++) {
			 // check if letter is in gcdStr
			 letter = str1.charAt(idx);
			 if(gcdStr.indexOf(letter) != -1) break;
			 // check if characters are equal starting from str1
			 if(letter == str2.charAt(idx)) gcdStr += letter;
		 }

		 // loop for checking if gcdStr repeats in str1
		 int gcdCount = 0;
		 for(int idx = 0; idx < str1L; idx++) {
			 // check if str1 contains gcdStr
			 if(str1.substring(idx).startsWith(gcdStr)) gcdCount++;
		 }

		 // check if gcdCount is greater than 1
		 if(gcdCount > 1) return gcdStr;
		 else return "";

	 }


	/** 1431. Kids With the Greatest Number of Candies
	 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/?envType=study-plan-v2&envId=leetcode-75
	 */
	// find if kid can have the greatest number of candies
	// if kid plus extra candies is greater than or equal to max candies
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> result = new ArrayList<>();
		// loop for value of max candies
		int maxCandies = 0;
		for(int candy : candies) {
			if(candy > maxCandies) maxCandies = candy;
		}
		// loop for checking if kid can have the greatest number of candies
		for(int candy : candies) {
			if(candy + extraCandies >= maxCandies) result.add(true);
			else result.add(false);
		}

		return result;
	}

	/** 605. Can Place Flowers
	 * https://leetcode.com/problems/can-place-flowers/description/?envType=study-plan-v2&envId=leetcode-75
	 */
	// can n number of flowers be planted without being adjacent to each other
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		boolean isPossible = false;
		// loop for counting adjacent 0's where its possible to plant
		int adjCount = 0;
		int length = flowerbed.length;
		for (int idx = 0; idx < length; idx++) {
			// check if current position is empty
			if (flowerbed[idx] == 0) {
				// check if previous and next positions are empty
				boolean emptyPrev = (idx == 0 || flowerbed[idx - 1] == 0);
				boolean emptyNext = (idx == length - 1 || flowerbed[idx + 1] == 0);

				// check if prev and next positions are empty
				if (emptyPrev && emptyNext) {
					// can plant flower
					flowerbed[idx] = 1;
					adjCount++;

					// check if n number of flowers can be planted
					if (adjCount >= n) {
						isPossible = true;
						break;
					}
				}
			}
		}

		return isPossible;
	}

	/** 345. Reverse Vowels of a String
	 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/?envType=study-plan-v2&envId=leetcode-75
	 */
	// reverse the vowels in the string
	public String reverseVowels(String s) {
		String newStr = "";
		// vowels
		String vowels = "aeiouAEIOU";
		// convert string to char array
		char[] sArr = s.toCharArray();
		// pointers for vowels
		int left = 0;
		int right = sArr.length - 1;
		// loop while reversing vowels
		while (left < right) {
			// check if left is a vowel
			if (vowels.indexOf(sArr[left]) == -1) {
				left++;
				continue;
			}
			// check if right is a vowel
			if (vowels.indexOf(sArr[right]) == -1) {
				right--;
				continue;
			}
			// swap vowels
			char temp = sArr[left];
			sArr[left] = sArr[right];
			sArr[right] = temp;
			// move pointers
			left++;
			right--;
		}

		// convert char array to string
		newStr = String.valueOf(sArr);
		return newStr;


	}










}
