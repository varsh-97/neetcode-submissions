class Solution {
    int rows;
    int cols;
    int maxArea = 0;
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        // dfs
        rows = grid.length;
        cols = grid[0].length;
        

        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                int count = 0;
                if(grid[i][j] == 1)
                {
                    count += dfs(grid, i, j);
                    maxArea = Math.max(maxArea, count);
                }
            }
        }
    return maxArea;
    }

    public int dfs(int[][] grid, int r, int c)
    {
        int total = 1; // atleast 1
        // base case
        if(r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == 0) return 0;

        // mark as visited
        grid[r][c] = 0;

        // dfs
        for(int[] d : dirs)
        {
            int nr = r + d[0];
            int nc = c + d[1];

            total += dfs(grid, nr, nc);
        }
        return total;
    }
}
