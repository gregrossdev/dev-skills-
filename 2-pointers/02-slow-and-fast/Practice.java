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
      // rotate k number at start of array
      reverse(nums, 0, k-1); 
      // rotate k number at end of array
      reverse(nums, k, n-1); 
    }
        
    public void reverse(int[] nums, int p1slow, int p2fast) {
      while (p1slow < p2fast) {
          int swap = nums[p1slow];
          nums[p1slow] = nums[p2fast];
          nums[p2fast] = swap;
            
          p1slow++;
          p2fast--;  
      }
    }
    
}

}