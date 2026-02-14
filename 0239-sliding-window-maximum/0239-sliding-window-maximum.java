class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 0 || k==0){
            return new int[]{0};
        }
        int ans[] = new int[n-k+1];
        Deque<Integer> window = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            while(window.size()>0 && window.peekFirst()<=(i-k)){
                window.pollFirst();
            }
            while(window.size()>0 && nums[window.peekLast()] < nums[i]){
                window.pollLast();
            }
            window.offerLast(i);
            if(i>=k-1){
                ans[i-k+1] = nums[window.peekFirst()];
            }
        }
        return ans;
    }
}