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
class FindElements {
    TreeNode nroot;
    Set<Integer> set;
    public void goRecoverTree(TreeNode root){
        if(root == null) return;
        if(root.left!=null){
            root.left.val = root.val*2 + 1;
        }
        goRecoverTree(root.left);
        if(root.right!=null){
            root.right.val = root.val*2 + 2;
        }
        goRecoverTree(root.right);
        set.add(root.val);
    }
    public FindElements(TreeNode root) {
        nroot = root;
        root.val = 0;
        set = new HashSet<>();
        goRecoverTree(root);
    }
   
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */