class Solution {
    public boolean isConnected(int src, int target, boolean[] visited,  List<Integer>[] adjList){
        visited[src] = true;
        if(src == target) return true;
        for(Integer adj: adjList[src]){
            if(!visited[adj]){
                if(isConnected(adj, target, visited, adjList)) return true;
            }
        }
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<Integer>[] adjList = new ArrayList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new ArrayList<>();
        }
        for(int[] edge: edges){
            boolean[] visited = new boolean[n];
            if(isConnected(edge[0]-1, edge[1]-1, visited, adjList)){
                return new int[]{edge[0], edge[1]};
            }
            else{
                adjList[edge[0]-1].add(edge[1]-1);
                adjList[edge[1]-1].add(edge[0]-1);
            }
        }
        return new int[] {};
    }
}