class Solution {
    public int recur(int[] nums, int target, int idx, int sum){
        if(idx>=nums.length ){
            if(target == sum) return 1;
            return 0;
        }
        return recur(nums, target, idx+1, sum-nums[idx]) + recur(nums, target, idx+1, sum+nums[idx]);
    }
    public int findTargetSumWays(int[] nums, int target) {
        return recur(nums, target, 0, 0);
    }
}