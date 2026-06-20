class Solution {
    public int largestAltitude(int[] gain) {
        
        int res=0, sum = 0;
        for(int i=1;i<=gain.length;i++){
            sum+=gain[i-1];
            res=Math.max(res,sum);
        }
        
        return res;
    }
}