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
    int ans, currK;
    public void findkthSmallest(TreeNode root, int k){
        if(root == null) return;
        findkthSmallest(root.left, k);
        this.currK+=1;
        if(currK == k) this.ans = root.val;
        findkthSmallest(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        findkthSmallest(root, k);
        return this.ans;
    }
}