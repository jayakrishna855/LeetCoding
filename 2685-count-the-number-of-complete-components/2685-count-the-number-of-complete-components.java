class Solution {
    public void dfs(int u, boolean[] visited, Map<Integer, List<Integer>> adjList, List<Integer> comp){
        visited[u] = true;
        comp.add(u);
        for(Integer v: adjList.getOrDefault(u, new ArrayList<>())){
            if(!visited[v]){
                dfs(v, visited,adjList, comp);
            }
        }
    }
    public boolean isCompleteConnected(List<Integer> comp, Map<Integer, List<Integer>> adjList){
        for(Integer u: comp){
            if(adjList.getOrDefault(u, new ArrayList<>()).size()!=comp.size()-1) return false;
        }
        return true;
    }
    public int countCompleteComponents(int n, int[][] edges) { 
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] edge: edges){
            adjList.computeIfAbsent(edge[0], k->new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k->new ArrayList<>()).add(edge[0]);
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                List<Integer> comp = new ArrayList<>();
                dfs(i, visited, adjList, comp);
                if(isCompleteConnected(comp, adjList)){
                    ans++;
                }
            }
        }
        return ans;
    }
}