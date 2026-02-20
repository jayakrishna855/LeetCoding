class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        int i = 0;
        while(i<n){
            if(set.size()>k){
                set.remove(nums[i-k-1]);
            }
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
            i++;
        }
        return false;
    }
}