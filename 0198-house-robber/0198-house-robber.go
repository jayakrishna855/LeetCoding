func getMax(nums []int, idx int, dp []int) int{
    if(idx>=len(nums)){
        return 0
    }
    if(dp[idx]!=-1){
        return dp[idx]
    }
    take:= nums[idx] + getMax(nums, idx+2, dp)
    nottake:= getMax(nums, idx+1, dp)
    dp[idx] = max(take, nottake)
    return dp[idx]
}

func rob(nums []int) int {
    dp:=make([]int, len(nums))
    for i:= range dp{
        dp[i] = -1
    }
    return getMax(nums, 0, dp)
}