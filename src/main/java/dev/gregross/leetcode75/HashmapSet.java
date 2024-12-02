package dev.gregross.leetcode75;

import java.util.*;

public class HashmapSet {
	/*
	 * Easy
	 ******************/
	// 2215. Find the Difference of Two Arrays
	public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		// Determine distinct integers in nums1 and nums2 using hashsets
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		for (int num : nums1) {
			set1.add(num);
		}
		for (int num : nums2) {
			set2.add(num);
		}
		// Find the difference of two arrays
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for (int num : set1) {
			if (!set2.contains(num)) {
				list1.add(num);
			}
		}
		for (int num : set2) {
			if (!set1.contains(num)) {
				list2.add(num);
			}
		}
		result.add(list1);
		result.add(list2);
		return result;
	}

	// 1207. Unique Number of Occurrences
	public boolean uniqueOccurrences(int[] arr) {
		// Determine the number of occurrences of each integer to see if they are unique
		// Store the integer and its occurrence in a hashmap
		HashMap<Integer, Integer> intMap = new HashMap<>();
		for (int intKey : arr) {
			intMap.put(intKey, intMap.getOrDefault(intKey, 0) + 1);
		}
		// Store the occurrences in a hashset to check if they are unique
		Set<Integer> occurrenceSet = new HashSet<>();
		for (int occurrence : intMap.values()) {
			if (occurrenceSet.contains(occurrence)) return false;
			occurrenceSet.add(occurrence);
		}

		return true;
	}
}
