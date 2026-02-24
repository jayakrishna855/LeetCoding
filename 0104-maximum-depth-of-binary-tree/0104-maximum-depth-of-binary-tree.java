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
    int maxd;
    public void fDepth(TreeNode root, int depth){
        maxd = Math.max(maxd, depth);
        if(root==null) return;
        fDepth(root.left, depth+1);
        fDepth(root.right, depth+1);
    }
    public int maxDepth(TreeNode root) {
        fDepth(root,0);
        return maxd;
    }
}