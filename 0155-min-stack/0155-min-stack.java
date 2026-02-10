class MinStack {
    private Node head;
    public MinStack() {

    }
    
    public void push(int val) {
        if(head == null){
            head = new Node(val,val,null);
        }
        else{
            if(val<head.min){
                head = new Node(val, val, head);
            }
            else{
                head = new Node(val, head.min, head);
            }
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
    
    private class Node{
        int val;
        int min;
        Node next;
        private Node(int v, int m, Node nxt){
            this.val = v;
            this.min = m;
            this.next = nxt;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */