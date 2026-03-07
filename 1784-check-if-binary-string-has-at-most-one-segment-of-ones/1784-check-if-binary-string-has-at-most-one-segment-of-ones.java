class Solution {
    public boolean checkOnesSegment(String s) {
        int i = 0, n = s.length(), j = n-1;
        while(i<n){
            if(s.charAt(i) == '1'){
                break;
            }
            i++;
        }
        while(j>=0){
            if(s.charAt(j) == '1'){
                break;
            }
            j--;
        }
        if(i==j || (i==n && j==-1)) return true;
        while(i<j){
            if(s.charAt(i) == '0') return false;
            i++;
        }
        return true;
    }
}