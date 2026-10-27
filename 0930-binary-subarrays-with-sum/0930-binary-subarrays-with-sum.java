class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0, csum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            csum+=num;
            if(csum==goal){
                ans+=1;
            }
            if(map.containsKey(csum-goal)){
                ans+=map.get(csum-goal);
            }
            map.put(csum, map.getOrDefault(csum, 0)+1);
        }
        return ans;
        
    }
}