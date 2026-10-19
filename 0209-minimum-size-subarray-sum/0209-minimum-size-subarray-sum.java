class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, left = 0, right = 0, ans = Integer.MAX_VALUE;
        while(right<nums.length){
            sum+=nums[right];
            while(sum>=target && left<=right){
                if((right-left+1)<ans){
                    ans = (right - left + 1);
                }
                sum-=nums[left];
                left++;
            }
            right++;
        }
        return (ans == Integer.MAX_VALUE)? 0:ans;
    }
}