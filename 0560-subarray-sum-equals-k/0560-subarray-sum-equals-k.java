class Solution {
    public int subarraySum(int[] nums, int k) {
       Map<Integer, Integer> map = new HashMap<>();
       int psum = 0, ans = 0;
       for(int num: nums){
            psum+=num;
            if(psum == k){
                ans+=1;
            } 
            if(map.containsKey(psum-k)){
                ans+=map.get((psum - k));
            }
            map.put(psum, map.getOrDefault(psum,0)+1);
       }
       return ans;

    }
}