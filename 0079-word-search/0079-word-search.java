class Solution {
    int m, n;
    public boolean wordExist(char[][] board, String word, int x, int y, int k, boolean[][] visited ){
        if(k==word.length()) return true;
        boolean down = false, up = false, left = false, right = false;
        visited[x][y] = true;
        if(x+1<m && !visited[x+1][y] && board[x+1][y] == word.charAt(k)){
            down = wordExist(board, word, x+1, y, k+1, visited);
            
        }
        if(y+1<n && !visited[x][y+1] && board[x][y+1] == word.charAt(k)){
            
            right = wordExist(board, word, x, y+1, k+1, visited);
            
        }
        if(x-1>=0 && !visited[x-1][y] && board[x-1][y] == word.charAt(k)){
            up = wordExist(board, word, x-1, y, k+1, visited);
            
        }
        if(y-1>=0 && !visited[x][y-1] && board[x][y-1] == word.charAt(k)){
            
            left = wordExist(board, word, x, y-1, k+1, visited);
            
        }
        visited[x][y] = false;

        return left || right || up || down;

    }
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    if(wordExist(board, word, i, j, 1, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}