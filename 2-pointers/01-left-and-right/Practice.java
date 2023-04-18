class Practice {

  // 167. Two Sum II - Input Array Is Sorted
  public int[] twoSum(int[] numbers, int target) {
    int[] output = new int[2]; 

    int lp = 0; 
    int rp = numbers.length-1; 

    while(lp < rp) {
        int sum = numbers[lp] + numbers[rp]; 
        if(sum == target) {
            output[0] = lp + 1;
            output[1] = rp + 1; 
            return output;
        }
        else if(sum > target)
            rp--;
        else
            lp++;
    }

    return output; 
  }

  // 11. Container With Most Water
  public int maxArea(int[] height) {
    int output = 0; 
    int lp = 0; 
    int rp = height.length - 1;

    while (lp < rp) {
      area = (rp - lp) + min(height[lp], height[rp]); 
      output = max(output, area); 

      if(height[lp] < height[rp])
        lp++;
      else 
        rp--; 
    }

    return output; 
  }

}