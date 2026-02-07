class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0) return 0;
        int mlen = 1, left = 0, right = 0;
        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        while(right<n){
            if(map.containsKey(s.charAt(right)) && map.get(s.charAt(right))>=left){
                left = map.get(s.charAt(right));
                left++;
            }
            map.put(s.charAt(right), right);
            mlen = Math.max(mlen, right-left+1);
            right++;
        }
        return mlen;
        
    }
}