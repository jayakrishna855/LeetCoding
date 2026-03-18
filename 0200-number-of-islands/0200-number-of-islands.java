class Solution {
    int m, n;
    public void dfs(int x, int y, boolean[][] visited, char[][] grid){
        if(x<0 || y<0 || x>=m || y>=n || visited[x][y] || grid[x][y] == '0'){
            return;
        }
        visited[x][y] = true;
        dfs(x+1, y, visited, grid);
        dfs(x-1, y, visited, grid);
        dfs(x, y+1, visited, grid);
        dfs(x, y-1, visited, grid);
    }
    public int numIslands(char[][] grid) {
        
        this.m = grid.length;
        this.n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(i, j, visited, grid);
                    count++;
                }
            }
        }
        return count;
    }
}