/*
 * LeetCode 110 - Balanced Binary Tree [easy]
 * LeetCode 113 - Path Sum II [medium]
 * LeetCode 129 - Sum Root to Leaf Numbers [medium]
 * LeetCode 200 - Number of Islands [medium]
 * LeetCode 257 - Binary Tree Paths [easy]
 * LeetCode 437 - Path Sum III [easy]
 */
class DepthFirstSearch {
  /**
   **112. Path Sum
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
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if(root == null) 
      return false;
    
    if(root.left == null && root.right == null &&  root.val == targetSum)
        return true;

    return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
  }

}