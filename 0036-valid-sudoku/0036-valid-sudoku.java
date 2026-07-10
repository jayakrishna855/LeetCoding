class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowmap = new boolean[9][9];
        boolean[][] colmap  = new boolean[9][9];
        boolean[][] boxmap = new boolean[9][9];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
               if(board[i][j]!='.'){
                    int num = board[i][j] - '1';
                    int boxIndex = (i/3) * 3 + (j/3);
                    if(rowmap[i][num] || colmap[num][j] || boxmap[boxIndex][num]){
                        return false;
                    }
                    rowmap[i][num] = true;
                    colmap[num][j] = true;
                    boxmap[boxIndex][num] = true;
               }
            }
        }
        return true;
    }
}