class Solution {
    int[][] dp;
    public int recur(int[] prices, boolean buy, int index){
        if(index == prices.length) return 0;
        int profit = 0;
        if(buy) profit = Math.max(-prices[index]+recur(prices, false, index+1), recur(prices, true, index + 1)); 
        else profit = Math.max(prices[index]+ recur(prices, true, index+1), recur(prices, false, index+1));
        return profit;
    }
    public int recurMem(int[] prices, int buy, int index){
        if(index == prices.length) return 0;
        int profit = 0;
        if(dp[index][buy]!=-1) return dp[index][buy];
        if(buy == 1) profit = Math.max(-prices[index]+recurMem(prices, 0, index+1), 0+recurMem(prices, 1, index + 1)); 
        else profit = Math.max(prices[index]+ recurMem(prices, 1, index+1), 0+recurMem(prices, 0, index+1));
        return dp[index][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n+1][2];

        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        // return recur(prices, true, 0);
        return recurMem(prices, 1, 0);


        // dp[n][0] = 0;
        // dp[n][0] = 0;
        // for(int i=n-1;i>=0;i--){
        //     for(int j=0;j<2;j++){
        //         if(j == 1){
        //             dp[i][j] = Math.max(-prices[i]+dp[i+1][0], dp[i+1][1]);
        //         }
        //         else{
        //             dp[i][j] = Math.max(prices[i]+dp[i+1][1], dp[i+1][0]);
        //         }
        //     }
        // }
        // return dp[0][1];
    }
}