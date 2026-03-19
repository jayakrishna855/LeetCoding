class Solution {
    int m, n;
    public boolean bfs(int i, int j, int[][] heights, boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;
        boolean isPacific = false, isAtlantic = false;
        while(!q.isEmpty() || ( !isPacific && !isAtlantic)){
            int[] pos = q.poll();
            if(pos == null) break;
            int x = pos[0], y = pos[1];
            int[][] dir = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
            for(int k=0;k<4;k++){
                int x1 = x + dir[k][0];
                int y1 = y + dir[k][1];
                if(x1<0 || y1<0){
                    isPacific = true;
                    continue;
                }
                else if(x1>=m || y1>=n){
                    isAtlantic = true;
                    continue;
                } 
                if(!visited[x1][y1] && heights[x1][y1]<= heights[x][y]){
                    q.add(new int[]{x1, y1});
                    visited[x1][y1] = true;
                }
            }
        }
        return (isPacific && isAtlantic);
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        this.m = heights.length;
        this.n = heights[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                boolean[][] visited = new boolean[this.m][this.n];
                if(bfs(i,j,heights, visited)){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }

        return ans;
    }
}