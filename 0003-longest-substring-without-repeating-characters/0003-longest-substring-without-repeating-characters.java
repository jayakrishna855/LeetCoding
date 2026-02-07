class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0) return 0;
        int mlen = 1, left = 0, right = 0;
        HashSet<Character> set = new HashSet<>();
        while(right<n){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            mlen = Math.max(mlen, right-left+1);
            right++;
        }
        return mlen;
        
    }
}