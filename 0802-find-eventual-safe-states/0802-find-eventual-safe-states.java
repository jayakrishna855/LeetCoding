class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
       int n = graph.length;
       boolean[] visited = new boolean[n];
       boolean[] inStack = new boolean[n];
       List<Integer> safeNodes = new ArrayList<>();
       for(int i=0;i<n;i++){
         if(!dfs(i, graph, visited, inStack)){
            safeNodes.add(i);
         }
       }
    //    for(int i=0;i<n;i++){
    //      if(!inStack[i]) safeNodes.add(i);
    //    }
       return safeNodes;
    }
    public boolean dfs(int node, int[][] graph, boolean[] visited, boolean[] inStack){
        if(inStack[node]) return true;
        if(visited[node]) return false;
        visited[node] = true;
        inStack[node] = true;
        for(int adjNode: graph[node]){
            if(dfs(adjNode, graph, visited, inStack)){
                return true;
            }
        }
        inStack[node] = false;
        return false;
    }
}