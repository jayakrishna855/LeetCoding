class Solution {
    int m,n;
    public void dfs(int x, int y, char[][] board){
        if(x<0 || y<0 || x>=this.m || y>=n || board[x][y]!='O') return;
        board[x][y] = '#';
        dfs(x+1, y, board);
        dfs(x-1, y, board);
        dfs(x, y+1, board);
        dfs(x, y-1, board);

    }
    public void solve(char[][] board) {
        this.m = board.length;
        this.n = board[0].length;
        boolean[][] visited = new boolean[this.m][this.n];
        for(int i=0;i<this.n;i++){
            if(board[0][i] == 'O') dfs(0, i, board);
        }
        for(int i=0;i<this.n;i++){
            if(board[this.m-1][i] == 'O') dfs(this.m-1, i, board);
        }
        for(int i=0;i<this.m;i++){
            if(board[i][0] == 'O') dfs(i, 0, board);
        }
        for(int i=0;i<this.m;i++){
            if(board[i][this.n-1] == 'O') dfs(i, this.n-1, board);
        }

        for(int i=0;i<this.m;i++){
            for(int j=0;j<this.n;j++){
                if(board[i][j]=='O') board[i][j] = 'X';
                else if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
}