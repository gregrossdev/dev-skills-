class Practice {

  // 26. Remove Duplicates from Sorted Array
  public int removeDuplicates(int[] nums) 
  {
    int output = 0; 
    int n = nums.length;

    int slow = 0;
    for (int fast = 1; fast < nums.length; fast++) 
      if (nums[fast] != nums[slow]) {
          slow++;
          nums[slow] = nums[fast];
      }
    
    output = slow + 1;
    return output; 
  }

}