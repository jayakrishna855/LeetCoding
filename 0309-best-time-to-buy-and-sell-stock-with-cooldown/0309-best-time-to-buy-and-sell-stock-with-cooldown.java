class Solution {
    Integer[][] dp;
    public int recur(int[] prices, int idx, int buy){
        if(idx>=prices.length) return 0;
        int profit = 0;
        if(dp[idx][buy]!=null) return dp[idx][buy];
        if(buy == 1) return dp[idx][buy]=Math.max(-prices[idx]+recur(prices, idx+1, 0), 0+recur(prices, idx+1, 1));
        else return dp[idx][buy]=Math.max(prices[idx]+recur(prices, idx+2, 1), 0+recur(prices, idx+1, 0));
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new Integer[n][2];
        return recur(prices,0,1);
    }
}