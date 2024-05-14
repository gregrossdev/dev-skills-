package leetcode.studyplan.leetcode_75;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
