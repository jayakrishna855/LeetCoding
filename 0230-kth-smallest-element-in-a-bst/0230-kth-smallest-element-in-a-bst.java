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
    // public void findkthSmallest(TreeNode root, int k){
    //     if(root == null) return;
    //     findkthSmallest(root.left, k);
    //     this.currK+=1;
    //     if(currK == k) this.ans = root.val;
    //     findkthSmallest(root.right, k);
    // }
    public int inorder(TreeNode root, int k){
        if(root == null) return 0;
        int left = inorder(root.left, k);
        if(left!=0) return left;
        currK++;
        if(currK == k) return root.val;
        int right = inorder(root.right, k);
        return right;
    }
    public int iterative(TreeNode root, int k){
        Stack<TreeNode> st = new Stack<>();
        while(true){
            if(root!=null){
                st.push(root);
                root = root.left;
            }
            else{
                if(st.isEmpty()) break;
                root = st.pop();
                k--;
                if(k==0){
                    return root.val;
                }
                root = root.right;
            }
        }
        return root.val;

    }
    public int kthSmallest(TreeNode root, int k) {
        // findkthSmallest(root, k);
        // return inorder(root, k);
        return iterative(root, k);
        //return this.ans;
    }
}