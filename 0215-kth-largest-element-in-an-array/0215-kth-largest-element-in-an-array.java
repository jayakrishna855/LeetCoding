class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<Integer>();
        int i =0;
        while(i<k){
            pq.add(nums[i]);
            i++;
        }
        while(i<nums.length){
            if(nums[i]>pq.peek()){
                pq.poll();
                pq.add(nums[i]);
            }
            i++;
        }
        return pq.peek();

    }
}