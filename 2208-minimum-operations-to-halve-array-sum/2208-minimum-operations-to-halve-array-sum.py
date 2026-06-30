class Solution:
    def halveArray(self, nums: List[int]) -> int:
        sum_value = sum(nums)
        heap = []
        for i in range(len(nums)):
            heapq.heappush(heap, -nums[i])
        count = 0
        sum_half = 0
        while True:
            num = -heapq.heappop(heap)
            num /= 2
            sum_half += num
            heapq.heappush(heap, -num)
            count += 1
            if sum_half * 2 >= sum_value:
                break
        return count
        