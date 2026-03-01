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
    int gnodes;
    public void gNodes(TreeNode root, int max){
        if(root == null) return;
        if(root.val >= max) this.gnodes+=1;
        gNodes(root.left, Math.max(root.val, max));
        gNodes(root.right, Math.max(root.val, max));
    }
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        gNodes(root, Integer.MIN_VALUE);
        return this.gnodes;
    }
}