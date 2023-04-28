/*
 * LeetCode 268 - Missing Number [easy]
 * LeetCode 442 - Find All Duplicates in an Array [medium]
 * LeetCode 448 - Find All Numbers Disappeared in an Array [easy]
 * LeetCode 645 - Set Mismatch [easy]
 */

class CyclicSort {

  // LeetCode 268 - Missing Number [easy]
  public int missingNumber(int[] nums) {
    int n = nums.length;

    int start = 0;
    while (start < n)
      if (nums[start] < n && start != nums[start])
        swap(nums, start, nums[start]);
      else
        start++;

    for (int i = 0; i < n; i++)
      if (nums[i] != i)
        return i;
    

    return n;
  }
  
  public void swap(int[] arr, int first, int second){
      int temp = arr[first];
      arr[first] = arr[second];
      arr[second] = temp;
  }
}