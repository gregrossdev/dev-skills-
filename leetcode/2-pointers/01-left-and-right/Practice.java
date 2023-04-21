class Practice {


	//--- 2 Sum problem coding pattern
	// Easy
	// 1. Two Sum	
	public int[] twoSum(int[] nums, int target) {
		int[] output = new int[2]; 
		int n = nums.length;

		for (int lp = 0; lp < n; lp++) 
			for (int rp = lp + 1; rp < n; rp++) 
				if(nums[lp] + nums[rp] == target)
					output = new int[]{lp, rp}; 

		return output; 
	}

	// Medium
	// 167. Two Sum II - Input Array Is Sorted
	public int[] twoSum(int[] numbers, int target) {
		int[] output = new int[2]; 
		int lp = 0, rp = numbers.length - 1;
		while(lp < rp){
				int sum = numbers[lp] + numbers[rp];
				if(sum == target) return output = new int[]{lp + 1, rp + 1};
				else if(sum < target) lp++;
				else rp--;
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

	// Medium
  // 1498. Number of Subsequences That Satisfy the Given Sum Condition
  public int numSubseq(int[] nums, int target) {
		int output = 0;
		Arrays.sort(nums);
		int n = nums.length; 
		int mod = (int) 1e9+7;

		int[] power = new int[n+1];
		power[0] = 1;
		for(int i = 1; i<power.length; i++)
				power[i] = (power[i-1]*2)%mod;
		
		int lp = 0; 
		int rp = n-1;
		while(lp<=rp){
				if(nums[lp]+nums[rp] <= target){
					output =( output + power[rp-lp])%mod;
					lp++;
				}
				else if(nums[lp]+nums[rp]>target) rp--;
				
		}

		return output;
	}

	// Easy 
	// 653. Two Sum IV - Input is a BST
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
	class FindTarget {
		public boolean findTarget(TreeNode root, int k) {
			List<Integer> list = new ArrayList();
			inorder(root, list);
			int lp = 0; 
			int rp = list.size() - 1;
			while (lp < rp) {
				int sum = list.get(lp) + list.get(rp);
				if (sum == k) return true;
				else if (sum < k) lp++;
				else rp--;
			}

			return false;
		}

		public void inorder(TreeNode root, List<Integer> list) {
			if (root == null)    return;
			inorder(root.left, list);
			list.add(root.val);
			inorder(root.right, list);
		}
	}

	// Medium
	// 633. Sum of Square Numbers
	public boolean judgeSquareSum(int c) { 
		long lp=0;
		long rp= (int) (Math.sqrt(c)) ;
		
		while(lp<=rp){
			long mid = (lp*lp) + (rp*rp);
			if(mid == c) return true;
			else if(mid > c) rp--;
			else lp++;
		}
		return false;
	}     

	// Medium
	// 881. Boats to Save People
	public int numRescueBoats(int[] people, int limit) {
		int output = 0;
		Arrays.sort(people);
		int lp = 0; 
		int rp = people.length - 1; 
		while (lp <= rp) {
			if (people[lp] + people[rp] <= limit) lp++;
			rp--;
			output++;
		}
		return output;
	}





















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