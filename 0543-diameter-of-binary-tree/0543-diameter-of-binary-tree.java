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
    int maxi;
    public int maxdiameterBT(TreeNode root){
        if(root == null) return 0;

        int lh = maxdiameterBT(root.left);
        int rh = maxdiameterBT(root.right);
        this.maxi = Math.max(this.maxi, lh+rh);
       
        return 1+ Math.max(lh, rh);

    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxdiameterBT(root);
        return this.maxi;
    }
}