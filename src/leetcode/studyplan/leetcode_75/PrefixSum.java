package leetcode.studyplan.leetcode_75;

public class PrefixSum {
	/*
	 * Easy
	 ******************/

	// 1732. Find the Highest Altitude
	public int largestAltitude(int[] gain) {
		// what is the highest altitude point
		int maxAlt = 0;
		// if we start from 0 and go through the array
		int startAlt = 0;
		for (int idx = 0; idx < gain.length; idx++) {
			// add the gain to the start
			startAlt += gain[idx];
			// if the start is higher than the max, update the max
			if (startAlt > maxAlt) maxAlt = startAlt;
		}

		return maxAlt;

	}

	// 724. Find Pivot Index
	public int pivotIndex(int[] nums) {
		// determine the leftmost pivot index ?
		// meaning the sum of the left side is equal to the sum of the right side
		int leftSum = 0;
		int rightSum = 0;
		// sum all the elements for right side
		for (int num : nums) rightSum += num;
		// iterate through the array
		for (int idx = 0; idx < nums.length; idx++) {
			// subtract the current element from the right sum
			rightSum -= nums[idx];
			// if the left sum is equal to the right sum, return the index
			if (leftSum == rightSum) return idx;
			// add the current element to the left sum
			leftSum += nums[idx];

		}

		return -1;

	}


}
