class Solution {
    boolean[][] pacific;
    boolean[][] atlantic;
    int row;
    int col;
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // need 2 grids for atlantic and pacific
        // iterate over the 0th row and 0th col for pacific and see the cells you can reach from those borders
        // do the same for atlantic and return the intersection b/w them
        // TC: O(row x col), SC: O(row x col)

        this.row = heights.length;
        this.col = heights[0].length;

        this.pacific = new boolean[row][col];
        this.atlantic = new boolean[row][col];

        List<List<Integer>> result = new ArrayList<>();

        // finding cells from top and bottom rows
        for(int i=0; i<col; i++)
        {
            dfsP(heights, 0, i);
            dfsA(heights, row-1, i);

        }

        // finding cells from left and right col
        for(int i=0; i < row; i++)
        {
            dfsP(heights, i, 0);
            dfsA(heights, i, col-1);
        }

        // check intersections and add to result
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                if(pacific[i][j] && atlantic[i][j]) result.add(Arrays.asList(i,j));
            }
        }
        return result;
    }

    public void dfsP(int[][] heights, int r, int c)
    {
        pacific[r][c] = true;

        for(int[] d : dirs)
        {
            int nr = r + d[0];
            int nc = c + d[1];
            if(nr < 0 || nr >= row || nc < 0 || nc >= col || pacific[nr][nc]) continue;

            if(heights[nr][nc] >= heights[r][c])
            {
                dfsP(heights, nr, nc);
            }    
        }
    }

    public void dfsA(int[][] heights, int r, int c)
    { 
        atlantic[r][c] = true;

        for(int[] d : dirs)
        {
            int nr = r + d[0];
            int nc = c + d[1];
            if(nr < 0 || nr >= row || nc < 0 || nc >= col || atlantic[nr][nc]) continue;

            if(heights[nr][nc] >= heights[r][c])
            {
                dfsA(heights, nr, nc);
            }    
        }
    }
}
