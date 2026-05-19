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
    public void inorder(TreeNode root, List<Integer> list){
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    public TreeNode buildBalancedBST(int inStart, int inEnd, List<Integer> list){
        if(inStart > inEnd) return null;
        int rootIdx = (inStart + inEnd)/2;
        TreeNode root = new TreeNode(list.get(rootIdx));
        root.left = buildBalancedBST(inStart, rootIdx-1, list);
        root.right = buildBalancedBST(rootIdx+1, inEnd, list);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        Map<Integer,Integer> map = new HashMap<>();
        int i = 0;
        for(Integer ele:list){
            map.put(ele, i++);
        }
        return buildBalancedBST(0,list.size()-1, list);
    }
}