class Solution {
    public int uniquePaths(int m, int n) {
        // at every square ask, what's the num of unique paths to reach the square above and to the left
        // dp[i] = dp[i][j-1] + dp[i-1][j]

        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1); // first row with 1
        for(int[] d : dp)
        {
            d[0] = 1; // first col with 1
        }

        for(int i=1; i < m; i++)
        {
            for(int j=1; j<n; j++)
            {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
