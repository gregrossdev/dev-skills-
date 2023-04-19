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
  


}