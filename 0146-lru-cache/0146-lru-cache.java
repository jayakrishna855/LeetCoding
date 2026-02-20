class Node{
    int key, val;
    Node prev;
    Node next;
    Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache {
    Map<Integer, Node> cache;
    int cap;
    Node oldest, latest;
    public LRUCache(int capacity) {
        this.cache = new HashMap<Integer, Node>();
        this.cap = capacity;
        this.oldest = new Node(-1,-1);
        this.latest = new Node(-1, -1);
        this.oldest.next = latest;
        this.latest.prev = oldest;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }

    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void insert(Node node){
        Node prev = latest.prev;
        node.prev = prev;
        prev.next = node;
        node.next = latest;
        latest.prev = node;
    }
    
    public void put(int key, int value) {
       if(cache.containsKey(key)){
        remove(cache.get(key));
       }
       Node newNode = new Node(key, value);
       cache.put(key, newNode);
       insert(newNode);

       if(cache.size()>cap){
        Node lru = oldest.next;
        remove(lru);
        cache.remove(lru.key);
       }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */