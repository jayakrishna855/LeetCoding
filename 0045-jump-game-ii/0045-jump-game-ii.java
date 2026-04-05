class Solution {
    public int jump(int[] nums) {
        int currMaxIndex = nums[0], nextMaxIndex = currMaxIndex, n = nums.length, jumps = 1;
        if(n == 1) return 0;
        for(int i=1;i<n-1;i++){
            nextMaxIndex = Math.max(i+nums[i], nextMaxIndex);
            if(currMaxIndex == i){
                currMaxIndex = nextMaxIndex;
                jumps+=1;
            }
        }
        return jumps;

    }
}