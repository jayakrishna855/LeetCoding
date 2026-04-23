class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int[] prefMax = new int[n];
        int[] suffMin = new int[n];
        for(int i=0;i<nums.length;i++){
            max = Math.max(max, nums[i]);
            prefMax[i] = max;
        }
        for(int i=n-1;i>=0;i--){
            min = Math.min(min, nums[i]);
            suffMin[i] = min;
        }
        for(int i=0;i<n;i++){
            if(prefMax[i]-suffMin[i]<=k){
                return i;
            }
        }
        return -1;
        
    }
}