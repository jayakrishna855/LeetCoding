class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean contains1 = false;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] == 1){
                contains1 = true;
            }
            else if(nums[i]<=0 || nums[i]>n){
                nums[i] = 1;
            }
        }
        if(!contains1){
            return 1;
        }
        for(int i=0;i<n;i++){
            int val = Math.abs(nums[i]);
            if(val == n){
                nums[0] = -Math.abs(nums[0]);
            }
            else{
                
                nums[val] = -Math.abs(nums[val]);
            }
        }
        for(int i=1;i<n;i++){
            if(nums[i]>0){
                return i;
            }
        }
        if(nums[0]>0){
            return n;
        }
        return n+1;
    }
}