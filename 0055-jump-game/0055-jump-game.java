class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        int maxIndex = nums[0];
        for(int i=1;i<nums.length-1;i++){
            if(i>maxIndex){
                return false;
            }
            else maxIndex = Math.max(maxIndex, i+nums[i]);
        }
        return maxIndex>=nums.length-1;
    }
}