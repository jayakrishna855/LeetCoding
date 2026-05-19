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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int maxWidth  = 0;
        while(!q.isEmpty()){
            int lvlLength = q.size();
            int lvlStart = q.peek().getValue();
            int idx = 0;
            for(int i=0;i<lvlLength;i++){
                Pair<TreeNode, Integer> pair = q.poll();
                TreeNode topNode = pair.getKey();
                idx = pair.getValue();
                if(topNode.left!=null){
                    q.add(new Pair<>(topNode.left, 2*idx));
                }
                if(topNode.right!=null){
                    q.add(new Pair<>(topNode.right, 2*idx+1));
                }
            }
            maxWidth = Math.max(maxWidth, idx - lvlStart+1);
            
        }
        return maxWidth;
    }
}