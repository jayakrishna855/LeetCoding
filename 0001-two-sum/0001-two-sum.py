class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        # for i in range(len(nums)):
        #     for j in range(i+1, len(nums)):
        #         if ((nums[i]+nums[j]) == target):
        #             return [i,j]
        # return []
        map = {}
        for i in range(len(nums)):
            map[nums[i]] = i
        
        for i in range(len(nums)):
            complement = target - nums[i]
            if(complement in nums and map[complement]!=i):
                return [map[complement], i]
        return []
