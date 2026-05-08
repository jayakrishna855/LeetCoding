class Solution {
    public boolean canBreak(String s, int sidx, List<String> wordDict, boolean[] dp, boolean[] visited){
        if(sidx>=s.length()) return true;
        if(visited[sidx]) return dp[sidx];
        visited[sidx] = true;
        for(int i=sidx+1;i<=s.length();i++){
            if(wordDict.contains(s.substring(sidx, i)) && canBreak(s, i, wordDict, dp, visited)){
                dp[sidx] = true;
                return true;
            }
        }
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        boolean[] visited = new boolean[s.length()+1];
        return canBreak(s,0,wordDict, dp, visited);
    }
}