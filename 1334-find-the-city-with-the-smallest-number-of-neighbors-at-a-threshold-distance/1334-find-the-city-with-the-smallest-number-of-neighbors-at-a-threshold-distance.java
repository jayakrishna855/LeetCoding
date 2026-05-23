class Solution {
    public void applyDijkstras(int[] distances, int src, Map<Integer, List<int[]>> adjList){
        Queue<int[]> queue = new LinkedList<>();
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;
        queue.add(new int[]{src, 0});

        while(!queue.isEmpty()){
            int u = queue.peek()[0], udist = queue.peek()[1];
            queue.poll();
            for(int[] edge: adjList.getOrDefault(u, new ArrayList<>())){
                int v = edge[0], vdist = edge[1];
                if(distances[v] > (udist + vdist)){
                    distances[v] = (udist + vdist);
                    queue.add(new int[]{v, distances[v]});
                }
            }
        }
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for(int[] edge: edges){
            adjList.computeIfAbsent(edge[0], k->new ArrayList<>()).add(new int[]{edge[1], edge[2]});
            adjList.computeIfAbsent(edge[1], k->new ArrayList<>()).add(new int[]{edge[0], edge[2]});

        }
        int[] distances = new int[n];
        int[] thresholdedCities = new int[n];
        for(int i=0;i<n;i++){
            Arrays.fill(distances, 0);
            applyDijkstras(distances, i, adjList);
            for(int j=0;j<n;j++){
                if(i!=j){
                    if(distances[j] <= distanceThreshold){
                        thresholdedCities[i]+=1;
                    }
                }
            }
            System.out.println(thresholdedCities[i]);
            
        }
        int minCities = n, city = 0;
        for(int i=0;i<n;i++){
            if(thresholdedCities[i]<=minCities){
                minCities = thresholdedCities[i];
                city = i;
            }
        }
        return city;
    }
}