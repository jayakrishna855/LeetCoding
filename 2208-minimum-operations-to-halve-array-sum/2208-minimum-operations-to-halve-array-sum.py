class Solution:
    def halveArray(self, nums: List[int]) -> int:
        total = sum(nums)
        half = total / 2
        ops = 0
        heap = [-float(x) for x in nums]
        heapify(heap)
        while total > half:
            ops += 1
            ntop = heap[0]
            ndiv = ntop / 2
            total -= -ndiv
            heapreplace(heap, ndiv)
        return ops
        