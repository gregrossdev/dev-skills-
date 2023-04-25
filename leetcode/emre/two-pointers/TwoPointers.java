package leetcode.emre.two-pointers;

public class TwoPointers {
  
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> output = new ArrayList<>();  
    int n = nums.length; 
    Arrays.sort(nums);

    for (int i = 0; i < n; i++) {
      int temp = nums[i]; 
      if(i != 0 && nums[i]==nums[i-1]) continue; 
      
      int end = n - 1; 
      int start = i + 1; 
      while(start < end) {
          int sum = temp + nums[start] + nums[end]; 
          if(sum == 0) {
            output.add(Arrays.asList(temp,nums[start],nums[end])); 
            end--; 
            start++;
            while(nums[start]==nums[start-1] && start < end) 
                start++; 
          }
          else if(sum > 0) start++;
          else end--;  
      }
    }
    
    
    return output; 
}

}
