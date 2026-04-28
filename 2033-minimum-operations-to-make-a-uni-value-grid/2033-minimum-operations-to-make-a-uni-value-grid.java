class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> ls = new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ls.add(grid[i][j]);
            }
        }
        Collections.sort(ls);
        int mid = (m*n)/2;
        int minOp1 = 0, minOp2 = 0;
        if((m*n)%2 == 0){
            int uniVal = ls.get(mid);
            for(int i=0;i<(m*n);i++){
                if((uniVal-ls.get(i))%x == 0){
                    minOp1 += Math.abs((uniVal - ls.get(i)))/x;
                    System.out.println(uniVal +" "+Math.abs((uniVal - ls.get(i))));
                }
                else{
                    return -1;
                }
            }
            uniVal = ls.get(mid-1);
            for(int i=0;i<(m*n);i++){
                if((uniVal-ls.get(i))%x == 0){
                    minOp2 += Math.abs((uniVal - ls.get(i)))/x;
                    System.out.println(uniVal +" "+Math.abs((uniVal - ls.get(i))));
                }
                else{
                    return -1;
                }
            }

            return Math.min(minOp1, minOp2);

        }
        else{
            int uniVal = ls.get(mid);
            int minOp = 0;
            for(int i=0;i<(m*n);i++){
                if((uniVal-ls.get(i))%x == 0){
                    minOp += Math.abs((uniVal - ls.get(i)))/x;
                }
                else{
                    return -1;
                }
            }
            return minOp;
        }
        
    }
}