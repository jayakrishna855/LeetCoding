class Solution {
    public int minFlips(String s) {
        int ans = s.length(), diff1 = 0, diff2 = 0, n = s.length();
        if(n==1) return 0;
        char[] t = (s+s).toCharArray();
        for(int i=0;i<2*n;i++){
            char expect1 = (i%2 == 0)? '0':'1';
            char expect2 = (i%2 == 0)? '1': '0';
            if(t[i] != expect1) diff1+=1;
            if(t[i] != expect2) diff2+=1;
            if(i>=n){
                char oldexpect1 = ((i-n)%2 == 0)? '0':'1';
                char oldexpect2 = ((i-n)%2 ==0)? '1': '0';
                if(t[i-n]!=oldexpect1) diff1--;
                if(t[i-n]!=oldexpect2) diff2--;
            }
            if(i>=n-1){
                ans = Math.min(ans, Math.min(diff1, diff2));
            }
        }
        return ans;

    }
}