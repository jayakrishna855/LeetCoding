class Solution {
    public int recur(int amt, int[] coins, int idx){
        if(amt == 0) return 1;
        if(idx>=coins.length) return 0;
        if(coins[idx]>amt){
            return recur(amt, coins, idx+1);
            
        }
        return recur(amt-coins[idx], coins, idx) + recur(amt, coins, idx+1);
    }
    public int recurMem(int amt, int[] coins, int idx, int[][] dp){
        if(amt == 0) return 1;
        if(idx>=coins.length) return 0;
        if(dp[idx][amt]!=-1){
            return dp[idx][amt];
        }
        if(coins[idx]>amt){
            return dp[idx][amt] = recurMem(amt, coins, idx+1, dp);
            
        }
        return dp[idx][amt] = recurMem(amt-coins[idx], coins, idx, dp) + recurMem(amt, coins, idx+1,dp);
    }
    public int change(int amount, int[] coins) {
        if(amount == 0){
            return 1;
        }
        int[][] dp = new int[coins.length][amount+1];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }
        // return recur(amount, coins, 0);
        return recurMem(amount, coins, 0, dp);
    }
}