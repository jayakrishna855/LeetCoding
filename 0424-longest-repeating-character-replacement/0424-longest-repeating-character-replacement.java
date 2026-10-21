class Solution {
    public int characterReplacement(String s, int k) {
        int right = 0, left = 0, maxSubstringLength = 1, maxfreq = 1;
        int[] freqMap = new int[26];
        while(right<s.length()){
            char ch = s.charAt(right);
            freqMap[ch -'A']+=1;
            maxfreq = Math.max(maxfreq, freqMap[ch-'A']);

            Boolean isValid = (right + 1 - left - maxfreq <= k);
            if(!isValid){
                ch = s.charAt(left);
                freqMap[ch - 'A']-=1;
                left+=1;
            }
            maxSubstringLength = right + 1 - left;
            right++;
           
        }
        return maxSubstringLength;
    }
}