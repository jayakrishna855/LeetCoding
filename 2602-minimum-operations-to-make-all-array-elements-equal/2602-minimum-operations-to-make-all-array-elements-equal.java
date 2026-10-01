class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] psum = new long[n+1];
        for(int i=0;i<n;i++){
            psum[i+1]+=nums[i]+psum[i];
        }
        List<Long> ans = new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            int q = queries[i];
            int idx = binarySearch(q, nums);
            System.out.println(idx);
            ans.add(1L * q * idx - psum[idx]+psum[n]-psum[idx]-1L * (n-idx) * q);

        }
        return ans;
    }
    public int binarySearch(int key, int[] nums){
        int low = 0, high = nums.length;
        while(low<high){
            int mid = low + (high-low)/2;
            if(key>nums[mid]){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
}