class Practice {

  // 167. Two Sum II - Input Array Is Sorted
  public int[] twoSum(int[] numbers, int target) {
    int[] output = new int[2]; 

    int lp = 0; 
    int rp = numbers.length-1; 

    while(lp < rp) {
        int sum = numbers[lp] + numbers[rp]; 
        if(sum == target) {
            output[0] = lp + 1;
            output[1] = rp + 1; 
            return output;
        }
        else if(sum > target)
            rp--;
        else
            lp++;
    }

    return output; 
  }

  // 11. Container With Most Water
  public int maxArea(int[] height) {
    int output = 0; 
    int lp = 0; 
    int rp = height.length - 1;

    while (lp < rp) {
      area = (rp - lp) + min(height[lp], height[rp]); 
      output = max(output, area); 

      if(height[lp] < height[rp])
        lp++;
      else 
        rp--; 
    }

    return output; 
  }

  // 15. 3Sum
  public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> output = new ArrayList<>();  
      Arrays.sort(nums);

      int n = nums.length; 
      for(int lp1 = 0; lp1<n; lp1++)
      {
          if(lp1 != 0 && nums[lp1]==nums[lp1-1]) continue; 
          int lp2 = lp1 + 1; 
          int rp  = n - 1; 
          while(lp2 < rp) 
          {
              if(nums[lp1] + nums[lp2] + nums[rp] == 0) {
                  output.add(Arrays.asList(nums[lp1],nums[lp2],nums[rp]));
                  lp2++;
                  while(lp2 < rp && nums[lp2]==nums[lp2-1]) 
                      lp2++; 
              }
              else if(nums[lp1] + nums[lp2] + nums[rp] < 0)
                  lp2++;
              else 
                  rp--; 
          }
      }
      
      return output; 
  }



}