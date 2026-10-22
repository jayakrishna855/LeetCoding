class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
       Map<Integer,Integer> modMap = new HashMap<>();
       int sum = 0;
       modMap.put(0,-1);
       for(int i=0;i<nums.length;i++){
         sum+=nums[i];;
         if(modMap.containsKey(sum%k)){
            if(i-modMap.get(sum%k) > 1) return true;
         }
         else{
            modMap.put(sum%k, i);
         } 
       }
       return false;
    }
}