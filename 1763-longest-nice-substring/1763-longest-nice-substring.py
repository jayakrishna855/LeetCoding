class Solution:
    def longestNiceSubstring(self, s: str) -> str:
        n = len(s)
        if n < 2:
            return ""

        # Check if the entire string is nice
        all_chars = set(s)
        if all(c.lower() in all_chars and c.upper() in all_chars for c in all_chars):
            return s

        # Find the first character that doesn't have its counterpart
        split_index = -1
        for i, char in enumerate(s):
            if char.lower() not in all_chars or char.upper() not in all_chars:
                split_index = i
                break

        # Recursively find the longest nice substring in the two halves
        left_nice = self.longestNiceSubstring(s[:split_index])
        right_nice = self.longestNiceSubstring(s[split_index + 1:])
        
        # Return the longer of the two halves
        return max(left_nice, right_nice, key=len)
        