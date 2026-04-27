class Solution {
    int[][][] dirs;  
    int m, n;  
    public boolean dfs(int[][] grid, boolean[][] visited, int x, int y){
        if(x == m-1 && y == n-1) return true;
        if(x>=m || x<0 || y>=n || y<0 || visited[x][y]) return false;

        visited[x][y] = true;
        for(int[] dir: dirs[grid[x][y]-1]){
            int x1 = x + dir[0], y1 = y + dir[1];
            if (x1 >= m || x1 < 0 || y1 >= n || y1 < 0) continue;
            boolean connected = false;
            for (int[] reverseDir : dirs[grid[x1][y1] - 1]) {
                if (reverseDir[0] == -dir[0] && reverseDir[1] == -dir[1]) {
                    connected = true;
                    break;
                }
            }
            if(connected && dfs(grid, visited,x1, y1)) return true;

        }
        return false;
    }
    public boolean hasValidPath(int[][] grid) {
        dirs = new int[7][][];
        dirs[0] = new int[][]{{0, -1}, {0,  1}};  
        dirs[1] = new int[][]{{-1, 0}, {1,  0}};  
        dirs[2] = new int[][]{{0, -1}, {1,  0}};  
        dirs[3] = new int[][]{{0,  1}, {1,  0}};  
        dirs[4] = new int[][]{{0, -1}, {-1, 0}};   
        dirs[5] = new int[][]{{0,  1}, {-1, 0}};  
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(grid, visited, 0, 0);
    }
}