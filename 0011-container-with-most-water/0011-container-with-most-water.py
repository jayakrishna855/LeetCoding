class Solution:
    def maxArea(self, heights: List[int]) -> int:
        left = 0
        right = len(heights) - 1
        max_area = 0
        while left < right:
            width = right - left
            height_left = heights[left]
            height_right = heights[right]
            height = min(height_left, height_right)
            max_area = max(max_area, width * height)
            if height_left > height_right:
                right -= 1
            else:
                left += 1
        return max_area
        