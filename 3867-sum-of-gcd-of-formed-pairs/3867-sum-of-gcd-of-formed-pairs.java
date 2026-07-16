class Solution {
    private int gcd(int min, int max){
        int r = max%min;
        if(r == 0) return min;
        return gcd(r, min);
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int max = nums[0];
        prefixGcd[0] = max;
        long sum = 0;
        for(int i=1;i<n;i++){
            max = Math.max(max, nums[i]);
            prefixGcd[i] = gcd(Math.min(max,nums[i]), Math.max(max,nums[i]));
        }
        Arrays.sort(prefixGcd);
        int i=0, j = n-1;
        while(i<j){
            sum+=gcd(prefixGcd[i], prefixGcd[j]);
            i++;
            j--;
        }
        return sum;
    }
}