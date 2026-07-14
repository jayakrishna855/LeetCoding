class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        //Set<String> set = new HashSet<>();
        for(int i=0;i<n;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            int j = i+1, k = n-1;
            while(j<k){
                int t = nums[i] + nums[j] + nums[k];
                if(t == 0){
                    // String triplhash = ""+nums[i]+"#"+nums[j]+"#"+nums[k];
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    while(j<k && nums[j] == nums[j-1]){
                        j++;
                    }
                }
                else if(t > 0){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return ans;
    }
}