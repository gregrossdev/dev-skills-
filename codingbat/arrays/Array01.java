class Array01 {

  public int[] makeMiddle(int[] nums) {
    int n = nums.length; 
    return new int[] {nums[n/2 -1], nums[n/2]};
  }

  public int[] midThree(int[] nums) {
    int mid = (nums.length - 1) / 2; 
    return new int[] { nums[mid - 1], nums[mid], nums[mid + 1] }; 
  }

  public int maxTriple(int[] nums) {
    int maxOf2 = Math.max(nums[0], nums[nums.length/2]); 
    int max = Math.max(maxOf2, nums[nums.length-1]);
    return max; 
  }









}