func countDigitOccurrences(nums []int, digit int) int {
    count := 0
    for _, num:= range nums{
        var n = num
        for n>0 {
            d := n%10
            if d==digit{
                count++
            }
            n/=10
        } 
    }
    return count
}