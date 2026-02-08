class Solution {
    boolean isPermutation(int[] count1, int[] count2){
        for(int i=0;i<26;i++){
            if(count1[i]!=count2[i]) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(char c:s1.toCharArray()){
            count1[c-97]+=1;
        }
        int left = 0;
        for(int right=0;right<s2.length();right++){
            if(right>=s1.length()){
                if(isPermutation(count1,count2)) return true;
                count2[s2.charAt(left)-97]-=1;
                left++;
            }
            
            count2[s2.charAt(right)-97]+=1;
            
        }
        return isPermutation(count1, count2);
    }
}