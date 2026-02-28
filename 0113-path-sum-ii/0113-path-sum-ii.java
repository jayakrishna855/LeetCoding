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
    List<List<Integer>> paths;
    public void pathSum(TreeNode root, int currSum, int targetSum, List<Integer> path){
        if(root == null) return;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(targetSum == currSum + root.val) this.paths.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        pathSum(root.left, currSum+root.val, targetSum, path);
        pathSum(root.right, currSum+root.val, targetSum, path);
        path.remove(path.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSum(root, 0, targetSum, path);
        return this.paths;
    }
}