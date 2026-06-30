class Solution:
    def halveArray(self, nums: List[int]) -> int:
        totalSum, currSum, steps = (0, 0, 0)
        for i in range(len(nums)):
            totalSum += nums[i]
        if totalSum == 0:
            return 0
        heap = [-num for num in nums]
        heapq.heapify(heap)
        while currSum < totalSum / 2.0:
            greatest = abs(heapq.heappop(heap)) / 2.0
            currSum += greatest
            heapq.heappush(heap, -abs(greatest))
            steps += 1
        return steps
        