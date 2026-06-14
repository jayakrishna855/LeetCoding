/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        int n=0;
        ListNode thead=head;
        Stack<Integer> st = new Stack<>();
        while(thead!=null){
            st.push(thead.val);
            thead=thead.next;
            n+=1;
        }
        int hf = n/2,max=0;
        while(n>0){
            max=Math.max(max,head.val+st.pop());
            n-=1;
            head=head.next;
        }
        return max;
    }
}