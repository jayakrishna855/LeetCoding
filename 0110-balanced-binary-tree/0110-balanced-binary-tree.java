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
    public int isBalance(TreeNode root){
        if(root == null) return 0;
        int lh = isBalance(root.left);
        int rh = isBalance(root.right);
        if(Math.abs(lh-rh)>1) return -1;
        if(lh == -1 || rh == -1) return -1;
        return 1+Math.max(lh, rh);
    }
    public boolean isBalanced(TreeNode root) {
        if(isBalance(root) == -1) return false;
        else return true;
        
    }
}