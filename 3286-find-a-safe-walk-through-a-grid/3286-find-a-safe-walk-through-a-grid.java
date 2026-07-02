class Solution {
    int m, n;

    //Refer: https://leetcode.com/problems/find-a-safe-walk-through-a-grid/solutions/8370646/using-0-1-bfs-converting-health-into-a-m-jaue
    // public boolean dfs(List<List<Integer>> grid, int x, int y, int health,  boolean[][] visited){
    //     if(x== m-1 && y == n-1) return health>0;
    //     if(x>=m || y>=n){
    //        return false;
    //     }
    //     visited[x][y] = true;
    //     if((x+1<m && !visited[x+1][y]) && ((grid.get(x+1).get(y)==1 && dfs(grid,x+1,y,health-1,visited)) || dfs(grid,x+1,y,health, visited))){
    //         return true;
    //     }
    //     if((y+1<n && !visited[x][y+1]) && ((grid.get(x).get(y+1)==1 && dfs(grid,x,y+1,health-1,visited)) || dfs(grid,x,y+1,health,visited))){
    //         return true;
    //     }
    //     if((x-1>=0 && !visited[x-1][y]) && ((grid.get(x-1).get(y)==1 && dfs(grid,x-1,y,health-1,visited)) || dfs(grid,x-1,y,health,visited))){
    //         return true;
    //     }
    //     if((y-1>=0 && !visited[x][y-1]) && ((grid.get(x).get(y-1)==1 && dfs(grid,x,y-1,health-1,visited)) || dfs(grid,x,y-1,health,visited))){
    //         return true;
    //     }
    //     visited [x][y] = false;
    //     return false;
        
    // }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] dist = new int[m][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        Deque<int[]> dq = new ArrayDeque<>();

        dist[0][0] = grid.get(0).get(0);
        dq.offerFirst(new int[]{0, 0});

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!dq.isEmpty()) {
            int[] curr = dq.pollFirst();
            int x = curr[0];
            int y = curr[1];

            if (x == m - 1 && y == n - 1)
                return dist[x][y] < health;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                    continue;

                int w = grid.get(nx).get(ny);

                if (dist[x][y] + w < dist[nx][ny]) {
                    dist[nx][ny] = dist[x][y] + w;

                    if (w == 0)
                        dq.offerFirst(new int[]{nx, ny});
                    else
                        dq.offerLast(new int[]{nx, ny});
                }
            }
        }

        return dist[m - 1][n - 1] < health;

    }
}