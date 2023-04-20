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


}