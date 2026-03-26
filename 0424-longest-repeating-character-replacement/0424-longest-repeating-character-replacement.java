class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, right = 0, max = 0, ans = 1;
        while(right<s.length()){
            
            count[s.charAt(right)-65]+=1;
            max = Math.max(count[s.charAt(right)-65], max);
           
            while((right-left+1)-max>k){
                    count[s.charAt(left)-65]-=1;
                    left++;
            }
            ans = Math.max(ans, (right-left+1));
            right++;
        }
        return ans;
    }
}