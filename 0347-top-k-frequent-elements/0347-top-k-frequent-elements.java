class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        for(Integer key: map.keySet()){
            if(pq.size()>=k){
                if(pq.peek()[1]<map.get(key)){
                    pq.poll();
                    pq.add(new int[]{key, map.get(key)});
                }
            }
            else{
                pq.add(new int[]{key, map.get(key)});
            }
        }
        int[] ans = new int[k];
        while(!pq.isEmpty()){
            ans[k-1] = pq.peek()[0];
            pq.poll();
            k--;
        }
        return ans;
    }
}