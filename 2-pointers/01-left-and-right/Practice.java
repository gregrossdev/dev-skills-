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

  

}