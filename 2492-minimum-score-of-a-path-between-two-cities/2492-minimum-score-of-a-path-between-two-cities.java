class Solution {
    public int minScore(int n, int[][] roads) {
        Map<Integer,List<int[]>> map = new HashMap<>();
        
        for(int i=1;i<=n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            map.get(roads[i][0]).add(new int[]{roads[i][1],roads[i][2]});
            map.get(roads[i][1]).add(new int[]{roads[i][0],roads[i][2]});
        }
        List<String> paths = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int[] visited = new int[n+1];
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int xR = q.poll();
            visited[xR] = 1;
            for(int[] road : map.get(xR)){
                min = Math.min(min,road[1]);
                if(visited[road[0]]!=1) q.add(road[0]);
                
            }
        }
        return min;
    }
}