class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int stone: stones){
            pq.add(stone);
        }
        while(pq.size()>1){
            int hs1 = pq.poll(), hs2 = pq.poll();
            //System.out.println(hs1 + " "+ hs2);
            if(hs2 < hs1){
                pq.add(hs1-hs2);
            } 
            else if(hs1 == hs2){
                continue;
            }
            
        }
        return (pq.size()==0)? 0:pq.peek();
    }
}