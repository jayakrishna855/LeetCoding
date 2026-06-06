class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int lsum = 0;
        for(int i=0;i<n;i++){
            ans[i] = lsum;
            lsum+=nums[i];
        }
        int rsum = 0;
        for(int i=n-1;i>=0;i--){
            ans[i] = Math.abs(ans[i]-rsum);
            rsum+=nums[i];
        }
        return ans;
    }
}