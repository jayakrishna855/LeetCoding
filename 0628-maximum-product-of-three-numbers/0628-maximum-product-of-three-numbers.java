class Solution {
    public int maximumProduct(int[] nums) {
         Arrays.sort(nums);
        int n=nums.length,max1=Integer.MIN_VALUE,max2=Integer.MIN_VALUE;
        max1=nums[n-1]*nums[n-2]*nums[n-3];
        if(nums[0]<0 && nums[1]<0){
            max2=nums[0]*nums[1];
            if(nums[n-1]<0){
                max2*=nums[2];
            }
            else{
                max2*=nums[n-1];
            }
        }
        return Math.max(max1,max2);
    }
}