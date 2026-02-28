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
class Solution {
    public boolean hasPathSum(TreeNode root, int currSum, int targetSum){
        if(root == null) return false;
        currSum+=root.val;
        if(root.left == null && root.right == null){
            if(currSum == targetSum) return true;
            else return false;
        }
        boolean left = hasPathSum(root.left, currSum, targetSum);
        boolean right = hasPathSum(root.right, currSum, targetSum);
        return left || right;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, 0, targetSum);
    }
}