class Practice {

	// Easy
	// 125. Valid Palindrome
	public boolean isPalindrome(String s) {  
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {

				Character lp = s.charAt(start);
				Character rp = s.charAt(end);
				
				if (!Character.isLetterOrDigit(lp)) {
						start++;
						continue; 
				}

				if (!Character.isLetterOrDigit(rp)) {
						end--;
						continue; 
				}

				if (Character.toLowerCase(lp) != Character.toLowerCase(rp)) 
						return false;
				
				start++;
				end--;    
		}
		
		return true;
	}

  // Medium
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

  // Medium
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

  // Medium
  // 15. 3Sum
  public List<List<Integer>> threeSum(int[] nums) {
	  List<List<Integer>> output = new ArrayList<>();  
	  Arrays.sort(nums);

	  int n = nums.length; 
	  for (int i = 0; i < n; i++) {
		if(i != 0 && nums[i]==nums[i-1]) continue; 

		int temp = nums[i]; 
		int lp = i + 1; 
		int rp = n - 1; 
		
		while(lp < rp) {
			int sum = temp + nums[lp] + nums[rp]; 
			if(sum > 0) rp--; 
			else if(sum < 0) lp++; 
			else {
				output.add(Arrays.asList(temp,nums[lp],nums[rp])); 
				rp--; 
				lp++;
				while(nums[lp]==nums[lp-1] && lp < rp) 
					lp++; 
			}
		}
	  }
	  
	  return output; 
  }

  // 75. Sort Colors
  class SortColors {
	public void sortColors(int[] nums) {
		int n = nums.length;
		if (n == 0 || n == 1) return; 

		int lp = 0;
		int rp = n - 1; 

		int index = 0; 
		while (index <= rp) {
			if (nums[index] == 2) {
				swap(nums, rp, index); 
				rp--;
			}
			else if (nums[index] == 0) {
				swap(nums, lp, index);
				lp++;
				index++; 
			}
			else 
				index++; 
		}
	}

	private void swap(int[] arr, int index1, int index2){
		int tmp = arr[index1]; 
		arr[index1] = arr[index2]; 
		arr[index2] = tmp; 
	}



  }

  // 283. Move Zeroes
  class moveZeroes {
	public void moveZeroes(int[] nums) {
		int n = nums.length; 
		if (nums == null || n == 0) return;
		
		int rp = 0;
		for (int lp = 0; lp < n; lp++) 
			if (nums[lp] != 0) 
				swap(nums, rp++, lp); 
	}

	private void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1]; 
		arr[index1] = arr[index2]; 
		arr[index2] = tmp; 
	}
  }

  // Hard
  // 42. Trapping Rain Water
  public int trap(int[] height) {
	int output = 0;
	int n = height.length;
	int lp = 0, rp = n - 1;
	int lpMax = height[lp], rpMax = height[rp];
	
	while (lp < rp) 
		if(lpMax < rpMax) {
			lp++; 
			lpMax =  Math.max(lpMax, height[lp]); 
			output += lpMax - height[lp]; 
		} 
		else {
			rp--; 
			rpMax = Math.max(rpMax, height[rp]); 
			output += rpMax - height[rp];						
		}
	
	return output;
}


}