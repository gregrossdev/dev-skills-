class Practice {

    // Easy
    // 704. Binary Search
    public int search(int[] nums, int target) {
			int output = -1; 
			
      int lp = 0;
			int rp = nums.length - 1;
			while (lp <= rp) {
					int midpoint = (lp + rp) / 2;

					if (nums[midpoint] == target) 
						return output = midpoint; 
					else if (nums[midpoint] < target) 
						lp = midpoint + 1; 
					else 
						rp = midpoint - 1;
			}

        return output;
    }
}
