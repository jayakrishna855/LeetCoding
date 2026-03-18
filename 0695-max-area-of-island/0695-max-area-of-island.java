class Solution {
    int m, n;
    public int dfs(int x, int y, int[][] grid, boolean[][] visited){
        if(x<0 || y<0 || x>=m || y>=n || grid[x][y] == 0 || visited[x][y]) return 0;
        visited[x][y] = true;
        return 1+dfs(x+1, y, grid, visited) + dfs(x-1, y, grid, visited)+dfs(x, y+1, grid, visited)+dfs(x, y-1, grid, visited);

    }
    public int maxAreaOfIsland(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    max = Math.max(max, dfs(i, j, grid, visited));
                }
            }
        }
        return max;
        
    }
}