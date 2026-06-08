class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int pc = 0, cpvt_less = 0;
        for(int num: nums){
            if(num == pivot) pc++;
            if(num<pivot) cpvt_less++;
        }
        int[] ans = new int[nums.length];
        int j = cpvt_less, i = cpvt_less-1;
        while(pc>0){
            ans[j] = pivot;
            j++;
            pc--;
        }
        for(int num: nums){
            if(num>pivot){
                ans[j] = num;
                j++;
            }
        }
        for(int k=nums.length-1;k>=0 && i>=0;k--){
            if(nums[k]<pivot){
                ans[i] = nums[k];
                i--;
            }
        }
        return ans;

    }
}