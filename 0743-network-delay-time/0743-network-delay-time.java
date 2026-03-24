class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] distance = new int[n+1];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)-> a[1]-b[1]);
        List<int[]>[] adjList = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            adjList[i] = new ArrayList<>();
        }
        for(int[] time: times){
            adjList[time[0]].add(new int[]{time[1],time[2]});
        }
        Arrays.fill(distance, Integer.MAX_VALUE);
        pq.add(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] nodeTime = pq.poll();
            if(nodeTime[1]<=distance[nodeTime[0]]){
                distance[nodeTime[0]] = nodeTime[1];
            }
            for(int[] neighbourNodeTime: adjList[nodeTime[0]]){
                if(nodeTime[1]+neighbourNodeTime[1]<distance[neighbourNodeTime[0]]){
                    pq.add(new int[]{neighbourNodeTime[0], neighbourNodeTime[1]+nodeTime[1]});
                }
            }
        }
        int max = -1;
        for(int i=1;i<=n;i++){
            max = Math.max(max, distance[i]);
        }

        return (max == Integer.MAX_VALUE) ? -1:max;


    }
}