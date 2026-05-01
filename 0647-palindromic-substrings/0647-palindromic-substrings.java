class Solution {
    // public boolean isPalindrome(String s, int i, int j, boolean[][] dp){
    //     if(i>=j) return true;
    //     if(dp[i][j]) return true;
    //     return (s.charAt(i) == s.charAt(j))? dp[i][j] = isPalindrome(s,i+1, j-1, dp): false;
        
    // }
    public int countSubstrings(String s) {
      
      
      int n = s.length();
      int count = n;
      boolean[][] dp = new boolean[n][n];
      for(int i=0;i<n;i++){
        dp[i][i] = true;
      }
      
      for(int i=0;i<n-1;i++){
         dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
         if(dp[i][i+1]) count++;
      }

      for(int len = 3;len<=n;len++){
        for(int i=0;i<=n-len;i++){
            int j = i + len -1;
            dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
            if(dp[i][j]) count++;
        }
      }
      return count;  
    }
}