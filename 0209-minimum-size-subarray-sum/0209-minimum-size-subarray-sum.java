class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       int left = 0, right = 0, sum = 0;
       int ans = Integer.MAX_VALUE;
       while(right<nums.length){
         if(sum>=target){
            while(sum>=target && left<=right){

                ans = Math.min(ans, (right-left));
                sum-=nums[left];
                left++;
            }
         }
         else{
            sum+=nums[right];
            right++;
         }
         
       }
       while(sum>=target && left<=right){
            ans = Math.min(ans, (right-left));
            sum-=nums[left];
            left++;
        }
       return ans == Integer.MAX_VALUE? 0:ans;
       
    }
}