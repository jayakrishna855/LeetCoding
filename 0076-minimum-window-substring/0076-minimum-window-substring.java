class Solution {
    boolean tFound(int[] count1, int[] count2){
        for(int i=0;i<128;i++){
            if(count1[i]>0 && count1[i]>count2[i]) return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        
        int[] count1 = new int[128];
        int[] count2 = new int[128];

        int left = 0, right = 0;
        int startIndex = 0, minLen = Integer.MAX_VALUE;
        
        for(char c: t.toCharArray()){
            count1[c]+=1;
        }
        
        while(right<s.length()){
            count2[s.charAt(right)]++;
            right++;
            while(tFound(count1, count2)){
                if(right - left < minLen){
                    minLen = right - left;
                    startIndex = left;
                }
                count2[s.charAt(left)]--;
                left+=1;
            }
        }
        
        return minLen==Integer.MAX_VALUE? "": s.substring(startIndex, startIndex+minLen);
    }
}