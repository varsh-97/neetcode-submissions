class Solution {
    int row;
    int col;
    String word;
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

    public boolean exist(char[][] board, String word) {
      // dfs in all 4 dirs from each cell
      // valid cell - if that char == word
      // base case - end of the word reached, return true
      // check boundaries and cell is unvisited
      // mark as visited
      // dfs with updated grid, index+1 from this new cell
      // TC: O(m x n x 4^L), SC: O(L), L=word len

      this.row = board.length;
      this.col = board[0].length;
      this.word = word;

      for(int i=0; i<row; i++)
      {
        for(int j=0; j<col; j++)
        {
            if(board[i][j] == word.charAt(0))
            {
                if(dfs(i, j, board, 0)) return true;
            }
        }
      }
      return false;
    }

    public boolean dfs(int i, int j, char[][] board, int index)
    {
        // base case
        if(index == word.length()) return true;

        if(i < 0 || j < 0 || i >= row || j >= col || board[i][j] != word.charAt(index)) return false;

        char temp = board[i][j];
        board[i][j] = '#';

        for(int[] d : dirs)
        {
            int nr = i + d[0];
            int nc = j + d[1];
            if(dfs(nr, nc, board, index+1)) 
            {
                board[i][j] = temp;
                return true;
            }
        }

        board[i][j] = temp;
        return false;
    }
}
