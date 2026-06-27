class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> freq = new HashMap<>();
        for(int num: nums){
            freq.merge((long)num, 1, Integer::sum);
        }

        int oneCnt = freq.getOrDefault(1L, 0);
        int ans = (oneCnt & 1) == 1? oneCnt : oneCnt -1;
        freq.remove(1L);

        for(long num: freq.keySet()){
            int res = 0;
            long x = num;

            while(freq.containsKey(x) && freq.get(x)>1){
                res+=2;
                x*=x;
            }

            ans = Math.max(ans, res + (freq.containsKey(x)? 1: -1));
        }
        return ans;
    }
}