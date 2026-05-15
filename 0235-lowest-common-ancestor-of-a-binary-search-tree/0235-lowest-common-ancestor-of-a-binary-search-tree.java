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
    TreeNode iterative(TreeNode root, TreeNode p, TreeNode q){
        
        TreeNode curr = root;
        while(curr!=null){
            if(p.val<curr.val && q.val<curr.val){
                curr = curr.left;
            }
            else if(p.val>curr.val && q.val>curr.val){
                curr = curr.right;
            }
            else{
                return curr;
            }
        }
        
        return null;
    }
    TreeNode recursive(TreeNode root, TreeNode p, TreeNode q){
        if(p.val<root.val && q.val<root.val){
            return recursive(root.left, p, q);
        }
        if(p.val>root.val && q.val>root.val){
            return recursive(root.right, p, q);
        }
        return root;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // return iterative(root, p, q);
        return recursive(root, p, q);
    }
}