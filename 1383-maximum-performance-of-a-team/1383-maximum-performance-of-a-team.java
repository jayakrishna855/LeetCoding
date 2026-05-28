class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] players = new int[n][2];
        for(int i=0;i<n;i++){
            players[i][0] = speed[i];
            players[i][1] = efficiency[i];
        }
        Arrays.sort(players,(p1,p2)->(p2[1]-p1[1]));
        long tperformance = 0, tspeed = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            if(pq.size()>=k){
                tspeed -= pq.poll();
            }
            pq.add(players[i][0]);
            tspeed += players[i][0];
            tperformance = Math.max(tperformance,tspeed * players[i][1]);
        }
        return (int)(tperformance%1000000007);
    }
    
  
}