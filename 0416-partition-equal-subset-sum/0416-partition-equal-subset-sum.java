class Solution {
    Boolean[][] dp;
    public boolean hasSubSet(int[] nums, int sum, int idx){
        if(sum==0) return true;
        if(idx>=nums.length || sum<0) return false;
        if(dp[idx][sum]!=null) return dp[idx][sum];
        return dp[idx][sum] = (hasSubSet(nums, sum-nums[idx], idx+1) || hasSubSet(nums, sum, idx+1));
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum+=num;
        }
        if(sum%2!=0) return false;
        dp = new Boolean[nums.length+1][(sum/2)+1];
        return hasSubSet(nums, sum/2, 0);
    }
}