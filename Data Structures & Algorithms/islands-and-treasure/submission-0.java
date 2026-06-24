class Solution {
    public void islandsAndTreasure(int[][] grid) {
       // multi-source BFS as we need the shortest dist to the treasure
       // TC: O(row x col), SC: O(m x n)

       Queue<int[]> queue = new LinkedList<>();
       int row = grid.length;
       int col = grid[0].length;

       for(int i=0; i<row; i++)
       {
        for(int j=0; j<col; j++)
        {
            if(grid[i][j] == 0)
            {
                queue.offer(new int[]{i,j});
            }
        }
       }
       int level = 1;
       int[][] dirs = {{1,0},{0,1},{0,-1},{-1,0}};

       while(!queue.isEmpty())
       {
            int size = queue.size();
            for(int i=0; i<size; i++)
            {
                int[] curr = queue.poll();
                for(int[] d : dirs)
                {
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];

                    if(nr < 0 || nc < 0 || nr >= row || nc >= col || grid[nr][nc] != 2147483647) continue;

                    grid[nr][nc] = level;
                    queue.offer(new int[]{nr, nc});
                }
            }
            level++;
       }
    }
}
