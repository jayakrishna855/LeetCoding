class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, lp = 1, rp = 1;
        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--){
            ans[i]=rp;
            rp= rp * nums[i];
        }
        for(int i=0;i<n;i++){
            ans[i]*=lp;
            lp = lp * nums[i];
        }
        return ans;
    }
}