class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // store the OG color in some var
        // from sr, sc do a 4-dir dfs and update every index with OG to color

        int og = image[sr][sc];
        int row = image.length;
        int col = image[0].length;
        if(og == color) return image;
        dfs(image, sr, sc, og, color, row, col);
        return image;
    }

    public void dfs(int[][] image, int r, int c, int og, int color, int row, int col)
    {
        if(r < 0 || c < 0 || r >= row || c >= col || image[r][c] != og) return;

        image[r][c] = color;

        dfs(image, r, c+1, og, color, row, col);
        dfs(image, r, c-1, og, color, row, col);
        dfs(image, r+1, c, og, color, row, col);
        dfs(image, r-1, c, og, color, row, col);
    }
}