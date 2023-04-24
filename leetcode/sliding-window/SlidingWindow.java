package leetcode.sliding-window;

public class SlidingWindow {

  // Medium
  // 3. Longest Substring Without Repeating Characters
  public int lengthOfLongestSubstring(String s) {
    int output = 0;

    int n = s.length();
    int[] chars = new int[128];

    
    int lp = 0;
    for(int rp = 0; rp < n; rp++) {
      lp = Math.max(chars[s.charAt(rp)], lp); 
      output = Math.max(output, rp - lp + 1);
      chars[s.charAt(rp)] = rp + 1;  
    }
    

    // O(n)
    return output;
  }
}
