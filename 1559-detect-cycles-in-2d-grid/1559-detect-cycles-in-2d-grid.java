class Solution {
    int m,n;
    static int[][] dirs = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
  
    public boolean isCycle(int x, int y, boolean[][] visited, char[][] grid, int px, int py){
        visited[x][y] = true;
        for(int[] d: dirs){
            int nx = x + d[0];
            int ny = y + d[1];
            if(nx != px || ny != py){
                if(nx >=0 && nx <m && ny>=0 && ny<n){
                    if(grid[nx][ny] == grid[x][y]){
                        if(visited[nx][ny] || isCycle(nx, ny, visited, grid, x, y)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;


    }
    public boolean containsCycle(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    //this.c = grid[i][j];
                    if(isCycle(i,j,visited,grid, -1, -1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}