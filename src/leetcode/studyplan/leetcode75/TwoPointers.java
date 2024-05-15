package leetcode.studyplan.leetcode75;

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

  // 392. Is Subsequence
  public boolean isSubsequence(String s, String t) {
    // # is s a subsequence of t
    boolean isS = false;
    int sLength = s.length();
    if(sLength == 0) return true;
    // ## find s index's in t
    int sIdx = 0;
    for(int tIdx = 0; tIdx < t.length() && sIdx < sLength; tIdx++) {
      // check if sequence of s is in t
      if(s.charAt(sIdx) == t.charAt(tIdx)) sIdx++;
    }

    if(sIdx == sLength) isS = true;

    return isS;
  }



}
