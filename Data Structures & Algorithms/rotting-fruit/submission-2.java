class Solution {
    public int orangesRotting(int[][] grid) {
        // bfs
        // count total fresh oranges and [i,j] of rotten oranges
        // add them to a queue and at each level, if the rot spreads then, count++. 
        // use boolean flag to check if rot spreads

        int row = grid.length;
        int col = grid[0].length;
        int freshOranges = 0;
        int minutes = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

        for(int i=0; i<row; i++) // count of fresh oranges, add rotten to queue
        {
            for(int j=0; j<col; j++)
            {
                if(grid[i][j] == 2) queue.offer(new int[]{i,j});
                if(grid[i][j] == 1) freshOranges++;
            }
        }

        if(freshOranges == 0) return 0; // impossible state
        if(queue.isEmpty()) return -1; // no rotten oranges 

        while(!queue.isEmpty())
        {
            boolean flag = false; 
            int size = queue.size();

            for(int i=0; i<size; i++)
            {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for(int[] d : dirs) // try all 4 dirs for each rotten
            {
                int nr = r + d[0];
                int nc = c + d[1];

                // boundary conditions
                if(nr < 0 || nr >= row || nc < 0 || nc >= col || grid[nr][nc] == 0 || grid[nr][nc] == 2) continue;

                // mark as visited
                grid[nr][nc] = 2; // mark as rotten
                freshOranges--; // reduce count
                queue.offer(new int[]{nr, nc});
                flag = true; // only if the rot spreads
            }
            }
            if(flag) minutes++; 
        }
        return freshOranges == 0 ? minutes : -1;
    }
}
