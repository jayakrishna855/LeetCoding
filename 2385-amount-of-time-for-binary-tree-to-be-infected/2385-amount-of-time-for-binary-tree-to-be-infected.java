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
    Map<TreeNode, TreeNode> map;
    TreeNode startNode;
    int start;
    public void markparents(TreeNode root, TreeNode parent){
        if(root == null) return;
        map.put(root, parent);
        if(root.val == start){
            this.startNode = root;
        }
        markparents(root.left, root);
        markparents(root.right, root);
    }
    public int amountOfTime(TreeNode root, int start) {
        map = new HashMap<>();
        this.start = start;
        markparents(root, null);
        Queue<TreeNode> q = new LinkedList<>();
        int nnodes= map.size();
        q.add(startNode);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(startNode);
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node.left!=null && !visited.contains(node.left)){
                    q.add(node.left);
                    visited.add(node.left);
                }
                if(node.right!=null && !visited.contains(node.right)){
                    q.add(node.right);
                    visited.add(node.right);
                }
                TreeNode parent = map.get(node);
                if(parent!=null && !visited.contains(parent)){
                    q.add(parent);
                    visited.add(parent);
                }
            }
            if(q.isEmpty()) return time;
            time++;
        }
        return time;

    }
}