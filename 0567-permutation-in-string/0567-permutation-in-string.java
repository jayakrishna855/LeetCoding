class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()) return false;
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];
        int right = 0, left = 0;
        for(right=0;right<s1.length();right++){
            s1Freq[s1.charAt(right)-97]+=1;
            s2Freq[s2.charAt(right)-97]+=1;
        }
        if(Ispermut(s1Freq, s2Freq)) return true;
        while(right<s2.length()){
            s2Freq[s2.charAt(left)-97]-=1;
            s2Freq[s2.charAt(right)-97]+=1;
            if(Ispermut(s1Freq, s2Freq)) return true;
            right++;
            left++;
        }

        return false;
    }
    public boolean Ispermut(int[] arr1, int[] arr2){
        for(int i=0;i<26;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
}