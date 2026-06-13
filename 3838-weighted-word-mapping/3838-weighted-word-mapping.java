class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String ans = "";
        for(String word: words){
            int sum = 0;
            for(char c: word.toCharArray()){
                sum+=weights[c-97];
            }
            int wmod = sum%26;
            ans+= (char)(122-wmod);
        }
        return ans;
    }
}