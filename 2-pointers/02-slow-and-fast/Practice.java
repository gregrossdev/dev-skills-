class Practice {

  // 26. Remove Duplicates from Sorted Array
  public int removeDuplicates(int[] nums) {
    int n = nums.length;
    
    int slow = 0;
    for (int fast = 1; fast < n; fast++) 
      if (nums[fast] != nums[slow]) {
          slow++;
          nums[slow] = nums[fast];
      }
    
    return slow + 1;
  }

  // 189. Rotate Array
  class RotateArray {
    public void rotate(int[] nums, int k) {
      int n = nums.length; 
      k %= n; 

      // rotate entire array 
      reverse(nums, 0, n-1); 
      // rotate beginning index=0, index=k-1
      reverse(nums, 0, k-1); 
      // rotate end index=k, index=n-1
      reverse(nums, k, n-1); 
    }
        
    public void reverse(int[] nums, int start, int end) {
      while (start < end) {
          int swap = nums[start];
          nums[start] = nums[end];
          nums[end] = swap;
            
          start++;
          end--;  
      }
    }
    
  }

  // 287. Find the Duplicate Number
  public int findDuplicate(int[] nums) {
    int slow = 0;
    int fast = 0; 
    
    while(true) {
      slow = nums[slow]; 
      fast = nums[nums[fast]]; 
      if(slow == fast) break; 
    }

    int temp = 0; 
    while(true) {
      slow = nums[slow];
      temp = nums[temp]; 
      if(slow == temp) return slow; 
    }
      
  }

}