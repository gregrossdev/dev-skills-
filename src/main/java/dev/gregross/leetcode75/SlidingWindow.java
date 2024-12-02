package dev.gregross.leetcode75;

public class SlidingWindow {
	/*
	 * Easy
	 ******************/
	// 643. Maximum Average Subarray I
	// 643. Maximum Average Subarray I
	public double findMaxAverage(int[] nums, int k) {
		// Find a contiguous subarray whose length has a max average value
		double maxAverage = 0;

		// Calculate the sum of the first 'k' elements
		double average = 0;
		for (int idx = 0; idx < k; idx++) {
			average += nums[idx];
		}

		// Calculate the average of the first 'k' elements
		maxAverage = average / k;

		// Slide the window through the rest of the array
		for (int idx = k; idx < nums.length; idx++) {
			// Add the new element to the window and remove the first element from the window
			average += nums[idx] - nums[idx - k];
			// Update maxAverage if the current average is greater
			maxAverage = Math.max(maxAverage, average / k);
		}

		// Return the maximum average
		return maxAverage;
	}

}
