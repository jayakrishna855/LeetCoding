class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0, m = intervals.length;
        List<int[]> ans = new ArrayList<>();

        while (i < m && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }

        while (i < m && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        ans.add(newInterval);

        while (i < m) {
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
        // while(i<m){
        //     if(newInterval[0] > intervals[i][0] && newInterval[0] <= intervals[i][1]){
        //         break;
        //     }
        //     else{
        //         ans.add(intervals[i]);
        //     }
        //     i++;
        // }
        // if(i>=m){
        //     ans.add(newInterval);
        // }
        
        // int start = intervals[i][0], end = Math.max(newInterval[1], intervals[i][1]);
        // i++;
        // while(i<m){
        //     if(end>=intervals[i][0] && end<=intervals[i][1]){
        //         end = Math.max(end, intervals[i][1]);
        //         ans.add(new int[]{start, end});
        //         break;
        //     }
        //     else{
        //         i++;
        //     }
        // }
        // i++;
        // while(i<m){
        //     ans.add(intervals[i]);
        //     i++;
        // }

        // int[][] result = new int[ans.size()][2];
        // i = 0;
        // for(int[] interval: ans){
        //     result[i] = new int[]{interval[0], interval[1]};
        //     i++;
        // }
        // return result;
        
    }
}