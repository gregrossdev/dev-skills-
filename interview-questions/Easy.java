class Easy {

    // 1. Two Sum
    // Time: O(n^2)
    public int[] twoSum(int[] nums, int target) {
      int[] output = new int[2]; 
      int n = nums.length;

      for (int lp = 0; lp < n; lp++) 
        for (int rp = lp + 1; rp < n; rp++) 
          if(nums[lp] + nums[rp] == target)
            output = new int[]{lp, rp}; 

      return output; 
    }

    // Time: O(n)
    public int[] twoSum(int[] nums, int target) {
      int[] output = new int[2]; 
      Map<Integer, Integer> map = new HashMap<>(); 

      for (int lp = 0; lp < nums.length; lp++) {
        if(map.containsKey(nums[lp])) {
            output[0] = map.get(nums[lp]);
            output[1] = lp;
            return output;
        }
        map.put(target - nums[lp], lp); 
      }

       return output; 
    }

    // 13. Roman to Integer
    // Time: ?O(n) 
    public int romanToInt(String s) {
        int output = 0;
        Map<Character, Integer> map = new HashMap<>(); 
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        output = map.get(s.charAt(s.length() - 1)); 
        for (int lp = s.length()-2; lp >= 0; lp--) 
          if(map.get(s.charAt(lp)) < map.get(s.charAt(lp + 1)))
            output -= map.get(s.charAt(lp)); 
          else 
            output += map.get(s.charAt(lp)); 
      
        return output;
    }

    // 14. Longest Common Prefix
    // Time: ?O(n)
    public String longestCommonPrefix(String[] strs) {
        String prefix = ""; 
        if (strs.length == 0) return "";
        prefix = strs[0];
        for (int lp=1; lp<strs.length; lp++) 
            while (strs[lp].indexOf(prefix) != 0) 
                prefix = prefix.substring(0, prefix.length() - 1);
            
        return prefix;
    }


}