class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       Set<Integer> set = new HashSet<>();
       int i = 0, j;
       if(k==0) return false;
       for(j=0;j<k && j<nums.length;j++){
         if(set.contains(nums[j])) return true;
         set.add(nums[j]);

       }
       while(j<nums.length){
         if(set.contains(nums[j])){
            return true;
         }
         set.remove(nums[i]);
         set.add(nums[j]);
         i++;
         j++;
       } 
       return false;

    }
}