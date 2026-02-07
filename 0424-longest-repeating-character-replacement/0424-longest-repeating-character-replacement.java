class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0, left = 0, mlen = 1, n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int right = 0; right<n;right++){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)+1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(right)));
            while((right-left+1)-maxFreq>k){
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                left++;
            }
            mlen = Math.max(mlen, right-left+1);
        }
        return mlen;
    }
}