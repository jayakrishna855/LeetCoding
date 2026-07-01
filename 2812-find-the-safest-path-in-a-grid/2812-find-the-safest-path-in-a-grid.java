class Solution {
    final int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] d = new int[n][n];
        Queue<int[]> msq = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j) == 1){
                    msq.add(new int[]{i,j});
                    d[i][j] = 0;
                }
                else{
                    d[i][j] = -1;
                }
            }
        }
        while(!msq.isEmpty()){
            int size = msq.size();
            while(size-->0){
                int[] curr = msq.poll();
                for(int[] dir: dirs){
                    int di = curr[0] + dir[0];
                    int dj = curr[1] + dir[1];
                    int val = d[curr[0]][curr[1]];
                    if(isValid(d, di, dj) && d[di][dj] == -1){
                        d[di][dj] = val + 1;
                        msq.add(new int[]{di, dj});
                    }
                }
            }
        }
        int low = 0, high = 0, res = -1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                high = Math.max(high, d[i][j]);
            }
        }

        while(low<=high){
            int mid = low + (high-low)/2;
            if(isValidSafeness(d, mid)){
                res = mid;
                low = mid+1;
            }
            else high = mid-1;
        }

        return res;
    }

    private boolean isValidSafeness(int[][] grid, int minSafeness){
        int n = grid.length;
        if(grid[0][0] < minSafeness || grid[n-1][n-1] < minSafeness){
            return false;
        }

        Queue<int[]> tq = new LinkedList<>();
        tq.add(new int[]{0,0});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        while(!tq.isEmpty()){
            int[] curr = tq.poll();
            if(curr[0] == n-1 && curr[1] == n-1) return true;
            for(int[] dir: dirs){
                int di = dir[0] + curr[0];
                int dj = dir[1] + curr[1];
                if(isValid(grid, di, dj) && !visited[di][dj] && grid[di][dj]>=minSafeness){
                    visited[di][dj] = true;
                    tq.add(new int[]{di, dj});
                }
            }
        }

        return false;
    }

    private boolean isValid(int[][] mat, int i, int j){
        int n = mat.length;
        return (i>=0 && i<n && j>=0 && j<n);
    }
}