class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]>pq  = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{0,0});
        Map<Integer, Integer> cache = new HashMap<>();
        int minCost = 0;
        while(!pq.isEmpty()){
            int u = pq.peek()[0];
            int cost = pq.peek()[1];
            pq.poll();
            if(visited[u]) continue;
            visited[u] = true;
            minCost+=cost;
            for(int v=0;v<n;v++){
                if(!visited[v]){
                    int distance = Math.abs(points[u][0]-points[v][0]) + Math.abs(points[u][1]-points[v][1]);
                    if(distance<cache.getOrDefault(v, Integer.MAX_VALUE)){
                        cache.put(v, distance);
                        pq.add(new int[]{v, distance});
                    }
                }
            }
           
        }
         return minCost;
    }
}