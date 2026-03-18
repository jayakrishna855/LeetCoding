/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        Map<Integer, Node> map = new HashMap<>();
        Node newStartNode = new Node(node.val);
        map.put(node.val, newStartNode);

        while(!q.isEmpty()){
            Node rnode = q.poll();
            Node newNode = map.get(rnode.val);
            List<Node> newNeighbors = new ArrayList<>();
            for(Node adjNode: rnode.neighbors){
                Node newadjNode;
                if(!map.containsKey(adjNode.val)){
                    newadjNode = new Node(adjNode.val);
                    map.put(adjNode.val,newadjNode);
                    q.add(adjNode);
                }
                else{
                    newadjNode = map.get(adjNode.val);
                }
                newNeighbors.add(newadjNode);   
            }
            newNode.neighbors = newNeighbors;
        }
        return newStartNode;
    }
}