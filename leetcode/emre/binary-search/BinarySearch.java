package leetcode.emre.binary-search;

public class BinarySearch {
  // LeetCode 704 - Binary Search [easy]
  public int search(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;

    while (start <= end) {
      int midpoint = (start + end) / 2;

      if (target == nums[midpoint])
        return midpoint;

      if (target < nums[midpoint])
        end = midpoint - 1;
      else
        start = midpoint + 1;
    }

    return -1;
  }

  // LeetCode 744 - Find Smallest Letter Greater Than Target [easy]
  public char nextGreatestLetter(char[] letters, char target) {
    char output = letters[0];
    int start = 0;
    int end = letters.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (letters[mid] == target) 
        start = mid + 1;
      else if (target > letters[mid]) 
        start = mid + 1;
      else if (letters[mid] > target) {
        output = letters[mid];
        end = mid - 1;
      }
    }
    return output;
  }
}
