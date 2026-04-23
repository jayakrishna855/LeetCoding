class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] grid = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        Arrays.sort(sources, (s1, s2)-> s2[2]-s1[2]);
        for(int[] source: sources){
            int x = source[0], y = source[1];
            q.offer(new int[]{x,y});
            grid[x][y] = source[2];
        }
        while(!q.isEmpty()){
            
           
                int[] source = q.poll();
                int x = source[0], y = source[1];
                
                int[][] dir = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
                for(int i=0;i<4;i++){
                    int x1 = x+dir[i][0], y1 = y+ dir[i][1];
                    if(x1<0 || x1>=n || y1<0 || y1>=m) continue;
                    if(grid[x1][y1] == 0){
                        q.offer(new int[]{x1,y1});
                        grid[x1][y1] =  grid[x][y];
                    } 
                }
        }
        return grid;
    }
}