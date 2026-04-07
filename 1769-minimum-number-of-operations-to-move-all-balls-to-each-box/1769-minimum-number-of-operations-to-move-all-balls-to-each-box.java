class Solution {
    public int[] minOperations(String boxes) {
        int moves = 0, n = boxes.length(), balls = 0;
        int[] ans = new int[n];
        for(int i=0;i<n;i++ ){
            ans[i] = moves;
            if(boxes.charAt(i) == '1') balls+=1;
            moves+=balls;
        }
        moves = 0;
        balls = 0;
        for(int i=n-1;i>=0;i--){
            ans[i]+=moves;
            if(boxes.charAt(i) == '1') balls+=1;
            moves+=balls;
        }
        return ans;
    }
}