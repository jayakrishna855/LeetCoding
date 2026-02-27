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
    public void sumNumbers(TreeNode root, List<Integer> numbers, StringBuilder number)
    {
        if(root == null) return;
        number.append(root.val);
        if(root.left == null && root.right == null){
            numbers.add(Integer.parseInt(number.toString()));
        }
        else{
            sumNumbers(root.left,numbers,number);
            sumNumbers(root.right,numbers,number);
        }
        
        if(number.length()>0)number.deleteCharAt(number.length()-1);

    }
    public int sumNumbers(TreeNode root) {
        List<Integer> numbers = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if(root ==null) return 0;
        sumNumbers(root,numbers,sb);
        int ans = 0;
        for(int i=0;i<numbers.size();i++){
            ans+=numbers.get(i);
        }
        return ans;
    }
}