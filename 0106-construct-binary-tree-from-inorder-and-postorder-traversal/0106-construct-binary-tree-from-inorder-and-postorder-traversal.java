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
    int postOrderIdx;
    public TreeNode build(int[] postorder, int inStart,int inEnd, Map<Integer, Integer> inMap){
        if(inStart > inEnd) return null;

        TreeNode root = new TreeNode(postorder[postOrderIdx--]);
        int rootIdx = inMap.get(root.val);
        root.right = build(postorder,rootIdx+1,inEnd,inMap);
        root.left = build(postorder,inStart, rootIdx-1, inMap);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inMap = new HashMap<>();;
        int i = 0;
        postOrderIdx = postorder.length-1;
        for(int node: inorder){
            inMap.put(node, i++);
        }
        return build(postorder, 0, inorder.length-1, inMap);
    }
}