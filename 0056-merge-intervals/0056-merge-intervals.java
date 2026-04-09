class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2)-> i1[0]-i2[0]);
        for(int[] interval: intervals){
            pq.add(interval);
        }
        int start = pq.peek()[0], end = pq.peek()[1];
        pq.poll();
        List<int[]> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            if(pq.peek()[0]>=start && pq.peek()[0]<=end){
                start = Math.min(pq.peek()[0], start);
                end = Math.max(end, pq.peek()[1]);
                pq.poll();
            }
            else{
                ans.add(new int[]{start, end});
                start = pq.peek()[0];
                end = pq.peek()[1];
                pq.poll();
            }
        }
        
        ans.add(new int[]{start, end});
       
        return ans.toArray(new int[ans.size()][]);

    }
}