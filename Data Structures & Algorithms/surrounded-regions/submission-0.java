class Solution {
    int row;
    int col;
    int[][] dirs = {{1,0},{0,1},{0,-1},{-1,0}};

    public void solve(char[][] board) {
        // start from the 0s in the border and mark every 0 that is reachable from this 0 as -1
        // the remaining 0s are unreachable
        // iterate over the board again and flip the -1s to X
        // TC: O(r x c), SC: O(m x n)
        row = board.length;
        col = board[0].length;

        for(int j=0; j<col; j++) // 0th row
        {
           if(board[0][j] == 'O') dfs(0, j, board);
           if(board[row-1][j] == 'O') dfs(row-1, j, board);
        }

        for(int i=0; i<row; i++)
        {
            if(board[i][0] == 'O') dfs(i, 0, board);
            if(board[i][col-1] == 'O') dfs(i, col-1, board);
        }

        // go over the board and flip Vs to Os and Os to X
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                if(board[i][j] == 'V') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    public void dfs(int r, int c, char[][] board)
    {
        // boundary conditions
        if(r < 0 || r >= row || c < 0 || c >= col || board[r][c] == 'X' || board[r][c] == 'V') return;

        board[r][c] = 'V';

        for(int[] d : dirs)
        {
            int nr = d[0] + r;
            int nc = d[1] + c;
            dfs(nr, nc, board);
        }
    }
}
