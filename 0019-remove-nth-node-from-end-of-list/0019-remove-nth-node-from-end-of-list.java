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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0, head);
        ListNode dummy = res;
        while(n>0){
            head= head.next;
            n--;
        }
        while(head!=null){
            dummy = dummy.next;
            head = head.next;
        }
        dummy.next = dummy.next.next;
        return res.next;
    }
}