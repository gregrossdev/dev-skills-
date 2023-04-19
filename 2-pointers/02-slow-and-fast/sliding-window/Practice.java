class Practice {

  // Easy
  // 121. Best Time to Buy and Sell Stock
  public int maxProfit(int[] prices) {
    int output = 0;

    int lp = 0;
    int rp = 1;
    while (rp < prices.length) 
      if (prices[lp] < prices[rp]) {
          output = Math.max(output, prices[rp] - prices[lp]);
          rp++;
      } 
      else {
          lp = rp;
          rp++;
      }
    
    return output;
  }

  // Medium
  // 3. Longest Substring Without Repeating Characters
  public int lengthOfLongestSubstring(String s) {
    int ouput = 0;
    int[] chars = new int[128];

    int lp = 0;
    int rp = 0;

    
    while (rp < s.length()) {
        char r = s.charAt(rp);
        chars[r]++;

        while (chars[r] > 1) {
            char l = s.charAt(lp);
            chars[l]--;
            lp++;
        }

        ouput = Math.max(ouput, rp - lp + 1);
        rp++;
    }
    return ouput;
  }

}