class Solution:
    def halveArray(self, nums: List[int]) -> int:
        target = sum(nums) / 2
        heap = [-n / 2 for n in nums]
        heapq.heapify(heap)
        halved = 0
        num_ops = 0
        while halved < target:
            num_ops += 1
            drop = -heapq.heappop(heap)
            halved += drop
            heapq.heappush(heap, -drop / 2)
        return num_ops
        