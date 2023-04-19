class Practice {
  
	// Easy 
  // 217. Contains Duplicate
	public boolean containsDuplicate(int[] nums) {
			Arrays.sort(nums);

			for(int i = 1; i < nums.length; i++) 
					if(nums[i] == nums[i-1]) 
							return true;
			
			return false; 
	}

	// Easy 
  // 242. Valid Anagram
	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) return false;

		int[] freq = new int[26];
		for (int p1 = 0; p1 < s.length(); p1++) {
				freq[s.charAt(p1) - 'a']++;
				freq[t.charAt(p1) - 'a']--;
		}

		for (int j: freq) 
				if (j != 0) return false;
		
		return true;
	}

	// Easy 
  // 1. Two Sum
  public int[] twoSum(int[] nums, int target) {
		int[] output = new int[2]; 

		Map<Integer, Integer> map = new HashMap<>(); 

		for (int i = 0; i < nums.length; i++) 
		{
				if(map.containsKey(nums[i])) {
						output[0] = map.get(nums[i]);
						output[1] = i;
						return output;
				}
				map.put(target - nums[i], i); 
		}

		return output; 
	}


}