class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // a small math trick with knapsack DP
        // we know that we need 2 subsets of +ve and -ve. This will add up to totalSum and difference should give the target
        // adding these 2 equations, 2xsum of +ve = totalSum+target, sum of +ve = (new total)/2
        // this will be our new target and we need to build the dp[] for this
        // dp[i] = number of ways of building this sum, dp[target] += dp[target-num]
        // TC: O(newTarget * n), SC: O(newTarget)
        
        int sum = 0;
        for(int n : nums) sum += n;
        int newSum = sum + target;
        if((Math.abs(target) > sum) || (newSum % 2 != 0)) return 0;

        int newTarget = newSum/2;

        int[] dp = new int[newTarget+1];
        dp[0] = 1; // base case
        for(int n : nums)
        {
            for(int i=newTarget; i>=n; i--)
            {
                dp[i] += dp[i-n]; 
            }
        }
        return dp[newTarget];
    }
}
