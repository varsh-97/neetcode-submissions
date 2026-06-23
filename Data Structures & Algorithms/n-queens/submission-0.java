class Solution {
    Set<Integer> cols = new HashSet<>();
    Set<Integer> diag = new HashSet<>();
    Set<Integer> antiD = new HashSet<>();
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // hashset for each col, diag=r+c, anti-diag=r-c
        // TC: O(n!), SC: O(n^2)

        char[][] board = new char[n][n];
        for(char[] r : board)
        {
            Arrays.fill(r, '.');
        }

        backtrack(board, 0);
        return result;
    }

    public void backtrack(char[][] board, int row)
    {
        if(row == board.length)
        {
            result.add(buildBoard(board));
            return;
        }

        for(int col = 0; col < board.length; col++)
        {
            int d = row + col;
            int ad = row - col;
            if(board[row][col] != '.' || cols.contains(col) || diag.contains(d) || antiD.contains(ad))
            {
                continue;
            }

            board[row][col] = 'Q';
            cols.add(col);
            diag.add(d);
            antiD.add(ad);

            backtrack(board, row+1);

            board[row][col] = '.';
            cols.remove(col);
            diag.remove(d);
            antiD.remove(ad);
        }
    }

    public List<String> buildBoard(char[][] board)
    {
        List<String> temp = new ArrayList<>();
        for(char[] r : board)
        {
            temp.add(new String(r));
        }
        return temp;
    }
}
