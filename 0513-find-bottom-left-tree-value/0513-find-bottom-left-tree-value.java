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
    int maxDepth = Integer.MIN_VALUE, minLevel=Integer.MAX_VALUE;
    int bottomValue;
    public void bottomValue(TreeNode root, int currDepth, int currLine){
        if(root==null) return;
        if(currDepth>this.maxDepth){
            this.maxDepth = currDepth;
            // if(currLine<=this.minLevel) this.minLevel = currLine;
            this.bottomValue = root.val;
        }
        bottomValue(root.left, currDepth+1, currLine-1);
        bottomValue(root.right, currDepth+1, currLine+1);
    }
    public int findBottomLeftValue(TreeNode root) {
        bottomValue(root, 0, 0);
        return this.bottomValue;

    }
}