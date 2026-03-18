class Solution {
    public int orangesRotting(int[][] grid) {
        int fo = 0, m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1) fo++;
            }
        }
        if(fo == 0) return 0;
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int[][] dir = new int[][]{{0,1},{1,0},{-1,0}, {0,-1}};


            for(int i=0;i<size;i++){
                int[] point = q.poll();
                int x = point[0], y = point[1];
               // System.out.println(x + " "+ y);
                for(int k=0;k<4;k++){
                    int x1= x + dir[k][0];
                    int y1= y + dir[k][1];
                    if(x1<0 || y1<0 || x1>=m || y1>=n || grid[x1][y1]!=1){
                        continue;
                    }
                    else if(grid[x1][y1] == 1){
                        grid[x1][y1] = 2;
                        q.add(new int[]{x1, y1});
                    }
                }  
            }
            if(!q.isEmpty()) time++;
            
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                   return -1;
                }
            }
        }
        return time;

    }
}