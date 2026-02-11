class Solution {
    public int search(int[] nums, int target) {
        int l = 0, h = nums.length;
        while(l<h){
            int mid = (l+h)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid]>target) h = mid;
            else l = mid+1;
        }
        return -1;
    }
}