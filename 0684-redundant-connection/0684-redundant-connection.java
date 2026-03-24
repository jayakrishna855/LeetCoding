class Solution {
    class Disjoint{
        List<Integer> parent = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();
        public Disjoint(int n){
            for(int i=0;i<n;i++){
                parent.add(i);
                rank.add(0);
            }

        }
        public int findUParent(int node){
            if(parent.get(node) == node){
                return node;
            }
            int ulp = findUParent(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        public void unionByRank(int u, int v){
            int ulp_u = this.findUParent(u);
            int ulp_v = this.findUParent(v);
            if(rank.get(ulp_u) > rank.get(ulp_v)){
                parent.set(ulp_v, ulp_u);
            }
            else if(rank.get(ulp_v) > rank.get(ulp_u)){
                parent.set(ulp_u, ulp_v);
            }
            else{
                parent.set(ulp_v, ulp_u);
                int rank_u = rank.get(ulp_u);
                rank.set(ulp_u, rank_u+1);
            }

        }
    }
    // public boolean isConnected(int src, int target, boolean[] visited,  List<Integer>[] adjList){
    //     visited[src] = true;
    //     if(src == target) return true;
    //     for(Integer adj: adjList[src]){
    //         if(!visited[adj]){
    //             if(isConnected(adj, target, visited, adjList)) return true;
    //         }
    //     }
    //     return false;
    // }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Disjoint ds = new Disjoint(n);

        for(int[] edge:edges){
            int u = ds.findUParent(edge[0]-1);
            int v = ds.findUParent(edge[1]-1);
            if(u == v){
                return new int[]{edge[0], edge[1]};
            }else{
                ds.unionByRank(edge[0]-1, edge[1]-1);
            }
        }
        // List<Integer>[] adjList = new ArrayList[n];
        // for(int i=0;i<n;i++){
        //     adjList[i] = new ArrayList<>();
        // }
        // for(int[] edge: edges){
        //     boolean[] visited = new boolean[n];
        //     if(isConnected(edge[0]-1, edge[1]-1, visited, adjList)){
        //         return new int[]{edge[0], edge[1]};
        //     }
        //     else{
        //         adjList[edge[0]-1].add(edge[1]-1);
        //         adjList[edge[1]-1].add(edge[0]-1);
        //     }
        // }
        return new int[] {};
    }
}