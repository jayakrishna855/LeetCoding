class Solution {
     Stack<Integer> st;
    public boolean dfs(Map<Integer,List<Integer>> map , int u, boolean[] visited, boolean[] pv){
        visited[u] = true;
        pv[u] = true;
        for(Integer v: map.get(u)){
            if(!visited[v]){
                if(dfs(map, v, visited, pv))
                   return true;
            }
            else if(pv[v]){
                return true;
            }
        }
        pv[u] = false;
        this.st.push(u);
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.st = new Stack<>();
        int n = numCourses;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++) map.put(i, new ArrayList<>());
        for(int[] pr: prerequisites){
            map.get(pr[1]).add(pr[0]);
        }
        boolean[] visited = new boolean[n];
        boolean[] pv = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(dfs(map,i,visited, pv))
                return new int[0];
            }
        }
        int[] ans = new int[n];
        int i=0;
        while(!this.st.isEmpty()){
            ans[i] = this.st.pop();
            i++;
        }
        return ans;
    }
}