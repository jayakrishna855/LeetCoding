class Solution {
    public int maxProduct(int[] nums) {
        int fwmax = 1, max = Integer.MIN_VALUE;
        for(int num:nums){
            fwmax*=num;
            max = Math.max(max, fwmax);
            if(fwmax == 0) fwmax = 1;
        }
        int bwmax = 1;
        for(int i=nums.length-1;i>=0;i--){
            bwmax*=nums[i];
            max = Math.max(max, bwmax);
            if(bwmax == 0) bwmax = 1;
        }
        return max;
    }
}