class Solution {
    public boolean canPartition(int[] nums) {
        // find if a subset with sum = totalSum/2 exists
        // build dp[] upto target sum
        // dp[i] = true if we can form that sum using the given numbers. By default dp[0]=true
        // 0-1 knapsack problem
        // TC: O(n * target), SC: O(target)

        int sum = 0;
        for(int n : nums) sum += n;

        if(sum % 2 != 0) return false;
        int target = sum / 2;

        boolean[] dp = new boolean[target+1]; 
        dp[0] = true; // base case

        for(int n : nums)
        {
            for(int i=target; i>=n; i--)
            {
                if(i-n >=0 && dp[i-n]) 
                {
                    dp[i] = true;
                }

                if(dp[target]) return true;
            }
        }
        return dp[target];
    }
}
