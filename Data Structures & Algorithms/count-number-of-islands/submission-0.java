class Solution {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    int r;
    int c;

    public int numIslands(char[][] grid) {
        this.r = grid.length;
        this.c = grid[0].length;
        int count = 0;

        for(int i = 0; i < r; i++)
        {
            for(int j=0; j<c; j++)
            {
                if(grid[i][j] == '1')
                {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int row, int col)
    {
        // base case
        if(row < 0 || row >= r || col < 0 || col >= c || grid[row][col] == '0') return ;

        // visit the node
        grid[row][col] = '0';

        // explore all 4 dirs
        for(int[] d : dirs)
        {
            int nr = row + d[0];
            int nc = col + d[1];
            dfs(grid, nr, nc);
        }
    }
}
