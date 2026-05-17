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
    public int maxDiameter(TreeNode root){
        if(root == null) return 0;
        int lheight = getHeight(root.left);
        int rheight = getHeight(root.right);
        int ld = maxDiameter(root.left);
        int rd = maxDiameter(root.right);
        return Math.max(lheight+rheight, Math.max(ld, rd));
    }
    public int getHeight(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return maxDiameter(root);
    }
}