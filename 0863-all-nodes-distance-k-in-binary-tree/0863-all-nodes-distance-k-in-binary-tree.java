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
    public void mapparents(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> map){
        if(root == null) return;
        map.put(root, parent);
        mapparents(root.left, root, map);
        mapparents(root.right, root, map);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        mapparents(root, null, map);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        int clevel = 0;
        Map<TreeNode, Boolean> visited = new HashMap<>();
        visited.put(target, true);
        while(!q.isEmpty()){
            int size = q.size();
            if(clevel == k) break;
            clevel++;
            for(int i=0;i<size;i++){
                TreeNode current = q.poll();
                if(current.left!=null && visited.get(current.left) == null){
                    q.add(current.left);
                    visited.put(current.left, true);
                    
                }
                if(current.right!=null && visited.get(current.right) == null){
                    q.add(current.right);
                    visited.put(current.right, true);
                   
                }
                if(map.get(current)!=null && visited.get(map.get(current)) == null){
                    q.add(map.get(current));
                    visited.put(map.get(current), true);
                    
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            result.add(q.poll().val);
        }
        return result;

    }
}