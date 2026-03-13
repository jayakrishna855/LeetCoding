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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((n1,n2)-> n1.val-n2.val);
        for(ListNode node: lists){
            if(node!=null) pq.add(node);
        }
        while(!pq.isEmpty()){
            ListNode leastNode = pq.poll();
            curr.next = new ListNode(leastNode.val);
            if(leastNode.next!=null){
                pq.add(leastNode.next);
            }
            curr = curr.next;
        }
        return head.next;
        
    }
}