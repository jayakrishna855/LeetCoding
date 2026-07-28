class Solution {
    public int gcd(int a, int b){
        if((b%a) == 0) return a;
        return gcd(b%a, a);
    }
    public int gcdOfOddEvenSums(int n) {
        int a = n * n, b = n * (n+1);
        return gcd(a, b);
    }
}