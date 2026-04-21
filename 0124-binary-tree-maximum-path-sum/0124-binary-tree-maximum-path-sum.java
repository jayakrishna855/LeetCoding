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
    int maxp;
    public int getMaxPS(TreeNode root){
        if(root == null) return 0;
        int ls = getMaxPS(root.left);
        int rs = getMaxPS(root.right);
        int tans = Math.max(root.val, Math.max(ls, rs)+root.val);
        maxp = Math.max(maxp, Math.max(tans,ls+rs+root.val));
        return tans;
    }
    public int maxPathSum(TreeNode root) {
        this.maxp = Integer.MIN_VALUE;
        getMaxPS(root);
        return maxp;
    }
}