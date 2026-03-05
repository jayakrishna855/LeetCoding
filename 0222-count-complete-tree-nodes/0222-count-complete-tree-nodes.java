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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int lh = getLeftHeight(root.left);
        int rh = getRightHeight(root.right);
        if(lh == rh) return ((2<<lh)-1);
        else return 1+countNodes(root.left)+countNodes(root.right);
    }
    public int getLeftHeight(TreeNode root){
        int height = 0;
        while(root!=null){
            height++;
            root = root.left;
        }
        return height;
    }
    public int getRightHeight(TreeNode root){
        int height = 0;
        while(root!=null){
            height++;
            root = root.right;
        }
        return height;
    }
}