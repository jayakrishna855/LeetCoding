class Solution {
    int[][][] dp;
    public int solve(int[] prices, int index, int tcount, boolean buy){
        if(index == prices.length || tcount == 2) return 0;
        if(buy) return Math.max(-prices[index]+solve(prices, index+1, tcount, false), solve(prices, index+1, tcount, true));
        else return Math.max(prices[index]+solve(prices, index+1, tcount+1, true), solve(prices, index+1, tcount, false));
    }
    public int solveMem(int[] prices, int idx, int buy, int tcount){
        if(idx == prices.length || tcount == 2) return 0;
        int profit = 0;
        if(dp[idx][buy][tcount]!=-1){
            return dp[idx][buy][tcount];
        }
        if(buy == 1){
            profit = Math.max(-prices[idx]+solveMem(prices, idx+1, 0, tcount),
                                0+solveMem(prices, idx+1, 1, tcount));
        }
        else{
            profit = Math.max(prices[idx]+solveMem(prices, idx+1, 1, tcount+1),
                            0+solveMem(prices, idx+1, 0, tcount));
        }
        return dp[idx][buy][tcount] = profit;
    }
    public int maxProfit(int[] prices) {
        // 
        int n = prices.length;
        dp = new int[n][2][2];
        for(int[][] d: dp){
            for(int[] arr: d){
                Arrays.fill(arr, -1);
            }
        }
        return solveMem(prices, 0, 1, 0);
        // return solve(prices, 0, 0, true);

        // For converting to bottom-up
        // Step1: Write the base cases
        // Step2: What are changing parameters, write them in reverse order
        // Step1: Copy the recurrence relation
    }
}