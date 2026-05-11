class Solution {
    public int lcs(String s1, String s2, int i, int j, int[][] dp){
        if(i == s1.length() || j== s2.length()) return 0;

        if(s1.charAt(i)==s2.charAt(j)) return 1 + lcs(s1,s2, i+1, j+1, dp);
        else return Math.max(lcs(s1, s2, i+1, j, dp), lcs(s1, s2, i, j+1, dp));
    }

    public int lcsMem(String s1, String s2, int i, int j, Integer[][] dp){
        if(i == s1.length() || j== s2.length()) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j] = 1 + lcsMem(s1,s2, i+1, j+1, dp);
        else return dp[i][j] = Math.max(lcsMem(s1, s2, i+1, j, dp), lcsMem(s1, s2, i, j+1, dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        Integer[][] dp = new Integer[text1.length()+1][text2.length()+1];
        // for(int i=1;i<=m;i++){
        //     for(int j=1;j<=n;j++){
        //         if(text1.charAt(i-1) == text2.charAt(j-1)){
        //             dp[i][j] = 1+dp[i-1][j-1];
        //         }
        //         else{
        //             dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        //         }
        //     }
        // }
        // 
        
        // System.out.println(sb.reverse().toString());
        
        //System.out.println(lcs(text1,text2,0,0, dp));
        // return dp[m][n];
        return lcsMem(text1, text2, 0, 0, dp);
    }
}