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
    public int sumNums(TreeNode root, String number){
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            return Integer.parseInt(number+root.val);
        }
        return sumNums(root.left, number+root.val) + sumNums(root.right, number+root.val);
    }
    public int sumNumbers(TreeNode root) {
        return sumNums(root, "");
    }
}