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


}
