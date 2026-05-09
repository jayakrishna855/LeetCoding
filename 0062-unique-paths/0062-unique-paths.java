class Solution {
    public int dfs(int m, int n, int x, int y){
        if(x==m-1 && y == n-1) return 1;
        if(x>=m || y>=n || y<0 || x<0) return 0;
        return (dfs(m, n, x+1, y) + dfs(m, n, x, y+1));
    }
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    grid[i][j] = 1;
                }
                else{
                    if(i-1>=0){
                        grid[i][j]+=grid[i-1][j];
                    }
                    if(j-1>=0){
                        grid[i][j]+=grid[i][j-1];
                    }
                }
            }
        }
        return grid[m-1][n-1];

    }
}