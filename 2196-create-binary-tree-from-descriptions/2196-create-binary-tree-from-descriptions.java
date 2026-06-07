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
    public TreeNode buildTree(int val, Map<Integer,int[]> map){
        if(val == -1) return null;
        TreeNode root = new TreeNode(val);
        root.left = buildTree(map.get(val)[0], map);
        root.right = buildTree(map.get(val)[1], map);
        return root;
    }
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> childs = new HashSet<>();
        Map<Integer, int[]> map = new HashMap<>();
        for(int[] d: descriptions){
            map.put(d[0], new int[]{-1,-1});
        }
        for(int[] d: descriptions){
            int root = d[0];
            boolean isLeft = (d[2] == 1)? true:false;
            if(isLeft) map.get(root)[0] = d[1];
            else map.get(root)[1] = d[1];
            childs.add(d[1]);
        }
        int parent = -1;
        for(int p: map.keySet()){
            if(!childs.contains(p)) parent = p;
        }
        for(int node: childs){
            if(!map.containsKey(node)) map.put(node, new int[]{-1,-1});
        }
        TreeNode root = buildTree(parent, map);
        return root;
    }
}