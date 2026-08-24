class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        List<List<Integer>> ans = new ArrayList<>();
        int rl = 1, rh = upper;
        int[] range = new int[upper+1];

        for(int i=0;i<nums.length;i++){
            if(nums[i]<=upper) range[nums[i]] = 1;
        }
        int j = 0;
        for(int i=lower;i<=upper;i++){
            if(range[i]!=1){
                rl = i;
                while(i<=upper && range[i]==0){
                    i++;
                }
                rh = i-1;
                List<Integer> r = new ArrayList<>();
                r.add(rl);
                r.add(rh);
                ans.add(r);
            }
        }
        return ans;
    }
}