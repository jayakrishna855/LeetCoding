class Solution {
    int m, n;
    public int maxScore(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
       
        int max = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            int curr = grid[i][0];
            for(int j=1;j<n;j++){
                max = Math.max(max, grid[i][j]+curr);
                if(i>0 && i<m-1 && j>0 && j<n-1) max = Math.max(max, grid[i][j]);
                curr = Math.max(grid[i][j], curr+grid[i][j]);
            }
        }

        for(int j=0;j<n;j++){
            int curr = grid[0][j];
            for(int i=1;i<m;i++){
                max = Math.max(max, grid[i][j]+curr);
                if(i>0&&i<m-1&&j>0&&j<n-1) max = Math.max(max, grid[i][j]);
                curr = Math.max(grid[i][j], curr+grid[i][j]);
            }
        }
        return max;

    }
}