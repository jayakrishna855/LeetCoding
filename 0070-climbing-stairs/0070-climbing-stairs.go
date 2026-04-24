func getWays(n int, dp []int) int {
    if (n<0){
        return 0
    } 
    if (n == 0){
        return 1
    }
    if(dp[n]!=0){
        return dp[n]
    } 
    dp[n] = getWays(n-1, dp) + getWays(n-2, dp)
    return dp[n]
}

func climbStairs(n int) int {
    var dp = make([]int, n+1)
    return getWays(n, dp)
}