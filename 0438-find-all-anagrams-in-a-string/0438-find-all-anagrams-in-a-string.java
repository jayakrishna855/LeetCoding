class Solution {
    public boolean isAnagram(int[] count1, int[] count2){
        for(int i=0;i<26;i++){
            if(count1[i]!=count2[i]) return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int k = p.length();
         
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        List<Integer> ans = new ArrayList<>();
        if(k>s.length()) return ans;
        for(int i=0;i<k;i++){
            count1[p.charAt(i)-97]+=1;
            count2[s.charAt(i)-97]+=1;
        }
        if(isAnagram(count1, count2)) ans.add(0);
        for(int i=k;i<s.length();i++){
            count2[s.charAt(i-k)-97]-=1;
            count2[s.charAt(i)-97]+=1;
            if(isAnagram(count1, count2)) ans.add(i-k+1);
        }
        return ans;
    }
}