class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]!=b[0])
            return a[0]-b[0];
            else return b[1]-a[1];
            });
        int i,n=intervals.length,start=intervals[0][0],end=intervals[0][1];
        int ans=1;
        for(i=1;i<n;i++){
            if(intervals[i][0]>=start && intervals[i][1]<=end){
                continue;
            }
            ans+=1;
            start=intervals[i][0];
            end=intervals[i][1];
            
        }
        return ans;
    }
}