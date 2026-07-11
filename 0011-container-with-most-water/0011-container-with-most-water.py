class Solution:
    def maxArea(self, height: List[int]) -> int:
        left, right = (0, len(height) - 1)
        max_area = 0
        while left < right:
            height_left, height_right = (height[left], height[right])
            if height_left < height_right:
                area = (right - left) * height_left
                while height[left] <= height_left and left < right:
                    left += 1
            else:
                area = (right - left) * height_right
                while height[right] <= height_right and left < right:
                    right -= 1
            if area > max_area:
                max_area = area
        return max_area
        