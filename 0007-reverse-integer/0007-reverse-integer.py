class Solution:
    def reverse(self, x: int) -> int:
        sign = x > 0
        x = abs(x)
        reverse = 0
        while x:
            if reverse > (2 ** 31 - 1) / 10:
                return 0
            reverse = reverse * 10 + x % 10
            x = x // 10
        return reverse if sign > 0 else -reverse
        