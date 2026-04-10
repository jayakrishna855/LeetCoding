class Solution {
    public int getmaxSubArray(int[] nums, int left, int right){
        if(left==right){
            return nums[left];
        }
        int mid = (left+right)/2;
        int leftMax = getmaxSubArray(nums, left, mid);
        int rightMax = getmaxSubArray(nums, mid+1, right);
        int jointMax = findmidMax(nums, left, mid, right);
        return Math.max(Math.max(leftMax, rightMax), jointMax);
    }
    public int findmidMax(int[] nums, int left, int mid, int right){
        int leftSum = Integer.MIN_VALUE, curr = 0, rightSum = Integer.MIN_VALUE;
        for(int i=mid;i>=left;i--){
            curr+=nums[i];
            leftSum = Math.max(leftSum, curr);
        }
        curr = 0;
        for(int i=mid+1;i<=right;i++){
            curr+=nums[i];
            rightSum = Math.max(rightSum, curr);
        }
        return (leftSum+rightSum);
    }
    public int maxSubArray(int[] nums) {
        return getmaxSubArray(nums, 0, nums.length-1);
    }
}