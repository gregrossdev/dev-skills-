package leetcode.studyplan.leetcode_75;

public class TwoPointers {
  /*
   * Easy
   ******************/

  // 283. Move Zeroes
  public void moveZeroes(int[] nums) {
      // move all zeros to the end of an array
      // remove all zeros from array and set the index order
      int zeros = 0;
      int indexOrder = 0;
      for(int idx = 0; idx < nums.length; idx++) {
          if(nums[idx] != 0) {
              nums[indexOrder] = nums[idx];
              indexOrder++;
          }
          else zeros++;
      }
      // append zeros to end of array
      for (int i = 0; i < zeros; i++) {
          int end = nums.length - 1;
          nums[end - i] = 0;
      }

  }
}
