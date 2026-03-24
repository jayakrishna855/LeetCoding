class Solution {
    int m, n;
    public boolean isSubIsland(int x, int y, int[][] grid1, int[][] grid2, boolean[][] visited ){
        if(x<0 || y<0 || x>=this.m || y>=this.n || visited[x][y] || grid2[x][y] == 0){
            return true;
        }
        
        visited[x][y] = true;
        boolean result = grid1[x][y] == 1;
        boolean down = isSubIsland(x+1, y, grid1, grid2, visited);
        boolean up = isSubIsland(x-1, y, grid1, grid2, visited);
        boolean right = isSubIsland(x, y+1, grid1, grid2, visited);
        boolean left = isSubIsland(x, y-1, grid1, grid2, visited);
        return  (result && left && right && up && down);
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        this.m = grid1.length;
        this.n = grid1[0].length;
        int ans = 0;
        boolean[][] visited = new boolean[this.m][this.n];
        for(int i=0;i<this.m;i++){
            for(int j=0;j<this.n;j++){
                if(grid2[i][j] == 1 && !visited[i][j]){
                    if(isSubIsland(i, j, grid1, grid2, visited)){
                        ans+=1;
                    }
                }
            }
        }
        return ans;
    }
}