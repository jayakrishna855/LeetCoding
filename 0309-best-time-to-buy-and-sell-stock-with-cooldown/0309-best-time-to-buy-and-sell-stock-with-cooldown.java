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
        dp = new Integer[n+2][2];
        // return recur(prices,0,1);
        for(Integer[] d: dp){
            Arrays.fill(d, 0);
        }
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<2;j++){
                if(j==1){
                    dp[i][j] = Math.max(-prices[i]+dp[i+1][0], 0+dp[i+1][1]);
                }
                else{
                    dp[i][j] = Math.max(prices[i]+dp[i+2][1], 0+dp[i+1][0]);
                }
            }
        }
        return dp[0][1];
    }
}