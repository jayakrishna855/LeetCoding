class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int count = 0;
        for(int num: nums){
            int n1 = num;
            while(n1>0){
                int d = n1%10;
                if(d == digit){
                    count++;
                }
                n1/=10;
            }
        }
        return count;
    }
}