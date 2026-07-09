class Solution {
    public int lastStoneWeightII(int[] stones) {
        // divide the stones into 2 group sums such that the subset sum is as close to totalSum/2
        // build dp[target+1] and the final ans would be the totalSum - 2*closest target
        // TC: O(n * target), SC: O(target)

        int sum = 0;
        for(int s : stones) sum += s;

        int target = sum / 2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true; // base case

        // knapsack DP
        for(int s : stones)
        {
            // build in reverse: target->stone to prevent double counting
            for(int i=target; i>=s; i--)
            {
                dp[i] = dp[i] || dp[i-s];
            }
        }

        for(int i=target; i>=0; i--)
        {
            if(dp[i]) return sum - 2*i; 
        }
        return 0;
    }   
}