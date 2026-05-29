class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int num:nums){
            int sum = 0;
            while(num>0){
                int d = num%10;
                num = num/10;
                sum+=d;
            }
            min = Math.min(min, sum);
        }
        return min;
    }

}