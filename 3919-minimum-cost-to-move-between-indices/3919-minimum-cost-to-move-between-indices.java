class Solution {
    public int[] minCost(int[] nums, int[][] queries) {
        int n = nums.length;

       
        int[] ans = new int[queries.length];
        int[] closest = new int[n];
        int[] forward = new int[n];
        int[] backward = new int[n];
        closest[0] = 1;
        closest[n-1] = n-2;
        for(int i=1;i<n-1;i++){
            if(Math.abs(nums[i]-nums[i-1])<=Math.abs(nums[i]-nums[i+1])){
                closest[i] = i-1;
            }
            else{
                closest[i] = i+1;
            }
        }

        for(int i=1;i<n;i++){
            forward[i]+=forward[i-1];
            if(closest[i-1] == i){
                forward[i]+=1;
            }
            else{
                forward[i]+= Math.abs(nums[i]-nums[i-1]);
            }
            
        }

        for(int i=n-2;i>=0;i--){
            backward[i]+=backward[i+1];
            if(closest[i+1] == i){
                backward[i]+=1;
            }
            else{
                backward[i]+= Math.abs(nums[i]-nums[i+1]);
            }
          
        }
        int k = 0;
        for(int[] query: queries){
            int l = query[0], r = query[1];
            if(l>r){
                ans[k] = backward[r]-backward[l];
            }
            else{
                ans[k] = forward[r] - forward[l];
            }
            k++;
        }



        
        return ans;
    }
}