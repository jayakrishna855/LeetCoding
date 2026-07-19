class Solution {
    public int gcd(int num1, int num2){
        if((num2%num1) == 0) return num1;
        return gcd(num2%num1, num1);
    }
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return gcd(min, max);
    }
}