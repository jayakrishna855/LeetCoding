class Solution:
    def reverse(self, x: int) -> int:
        string = list(str(abs(x)))
        string = string[::-1]
        string = int(''.join(string))
        if x >= 0:
            string = string * 1
        else:
            string = string * -1
        if string <= 2 ** 31 - 1 and string >= -2 ** 31:
            return string
        else:
            return 0
        