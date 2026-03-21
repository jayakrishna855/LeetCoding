class Solution {
    public boolean dfs(Map<Integer, List<Integer>> map, int u, boolean[] visited, boolean[] pathVisited){
        visited[u] = true;
        pathVisited[u] = true;
        for(Integer v: map.get(u)){
            if(!visited[v]){
                if(dfs(map, v, visited, pathVisited)){
                    return true;
                }
            }
            else if(pathVisited[v]){
                return true;
            }
        }
        pathVisited[u] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] pr: prerequisites){
            map.computeIfAbsent(pr[1], k->new ArrayList<>()).add(pr[0]);
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(dfs(map, i, visited, pathVisited))
                return false;
            }
        }
        return true;
    }
}