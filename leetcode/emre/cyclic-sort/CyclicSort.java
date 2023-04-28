/*
 * LeetCode 268 - Missing Number [easy]
 * LeetCode 442 - Find All Duplicates in an Array [medium]
 * LeetCode 448 - Find All Numbers Disappeared in an Array [easy]
 * LeetCode 645 - Set Mismatch [easy]
 */

class CyclicSort {
  // LeetCode 268 - Missing Number [easy]
  class MissingNumber {
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

    public void swap(int[] arr, int lp, int rp) {
      int temp = arr[lp];
      arr[lp] = arr[rp];
      arr[rp] = temp;
    }
  }

  // LeetCode 442 - Find All Duplicates in an Array [medium]
  class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
      List<Integer> output = new ArrayList<Integer>();
      int n = nums.length;

      int start = 0;
      while (start < n) {
        int correct = nums[start] - 1;
        if (nums[start] != nums[correct])
          swap(nums, start, correct);
        else
          start++;
      }

      for (int i = 0; i < n; i++)
        if (nums[i] != i + 1)
          output.add(nums[i]);

      return output;
    }

    public void swap(int[] arr, int lp, int rp) {
      int temp = arr[lp];
      arr[lp] = arr[rp];
      arr[rp] = temp;
    }
  }

}