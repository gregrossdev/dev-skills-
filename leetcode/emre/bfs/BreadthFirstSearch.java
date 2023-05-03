package leetcode.emre.bfs;

/*
 * LeetCode 103 - Binary Tree Zigzag Level Order Traversal [medium]
 * LeetCode 104 - Maximum Depth of Binary Tree [easy]
 * LeetCode 107 - Binary Tree Level Order Traversal II [easy]
 * LeetCode 111 - Minimum Depth of Binary Tree [easy]
 * LeetCode 637 - Average of Levels in Binary Tree [easy]
 * LeetCode 994 - Rotting Oranges [easy]
 */

public class BreadthFirstSearch {
  /**
   **102. Binary Tree Level Order Traversal
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
  public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> output = new ArrayList<>();
		if (root == null)
			return output;
      
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> currLevel = new ArrayList<>();

			for(int i = 0; i < levelSize; i++) {
				TreeNode currNode = queue.poll();
				currLevel.add(currNode.val);
        
				if (currNode.left != null)
					queue.add(currNode.left);
				if (currNode.right != null)
					queue.add(currNode.right);
			}

			output.add(currLevel);
		}

		return output;
	}
}
