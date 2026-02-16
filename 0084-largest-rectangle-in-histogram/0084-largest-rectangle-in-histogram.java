class Solution {
    public int largestRectangleArea(int[] nums) {
        int n = nums.length;
        int[] leftSmallIndexes = new int[n];
        int[] rightSmallIndexes = new int[n];
        int ans = 0;
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0;i<n;i++){
            if(st.empty()){
                st.push(i);
                leftSmallIndexes[i] = 0;
            }
            else{
                while(!st.empty() && nums[st.peek()]>=nums[i]){
                    st.pop();
                }
                if(st.empty()) leftSmallIndexes[i] = 0;
                else leftSmallIndexes[i] = st.peek()+1;
                st.push(i);
            }
        }
        while(!st.empty()){
            st.pop();
        }
        for(int i=n-1;i>=0;i--){
            if(st.empty()){
                st.push(i);
                rightSmallIndexes[i] = n-1;
            }
            else{
                while(!st.empty() && nums[st.peek()]>=nums[i]){
                    st.pop();
                }
                if(st.empty()) rightSmallIndexes[i] = n-1;
                else rightSmallIndexes[i] = st.peek()-1;
                st.push(i);
            }
        }
        for(int i=0;i<n;i++){
            int h = nums[i], w = (i-leftSmallIndexes[i]) + (rightSmallIndexes[i]-i) + 1;
            ans = Math.max(ans, h*w);
        }
        return ans;
        
    }
}