func getMinCost(idx int, arr []int, dp []int) int{
   if idx < 0 {
        return 0
    }

    if idx == 0 {
        return arr[0]
    }

    if idx == 1 {
        return arr[1]
    }

    if dp[idx] != -1 {
        return dp[idx]
    }

    dp[idx] = arr[idx] + min(getMinCost(idx-1, arr, dp), getMinCost(idx-2, arr, dp))
    return dp[idx]
}
func minCostClimbingStairs(cost []int) int {
    n := len(cost)
    dp := make([]int, n)
    for i := range dp {
        dp[i] = -1
    }

    return min(getMinCost(n-1, cost, dp), getMinCost(n-2, cost, dp))
}