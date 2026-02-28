/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lcs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || q == root) return root;
        TreeNode leftLCS = lcs(root.left, p, q);
        TreeNode rightLCS = lcs(root.right, p, q);
        if(leftLCS == null) return rightLCS;
        else if(rightLCS == null) return leftLCS;
        else return root;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lcs(root, p, q);
    }
}