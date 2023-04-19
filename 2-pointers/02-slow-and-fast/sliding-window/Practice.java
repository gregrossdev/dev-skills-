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

}