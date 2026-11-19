class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x<0 or (x%10 == 0 and x!=0):
            return False
        reversedNo = 0
        while(x>reversedNo):
            reversedNo = reversedNo*10 + x%10
            x//=10
        return x==reversedNo or x==reversedNo//10
        