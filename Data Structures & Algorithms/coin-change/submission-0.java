class Solution {
    public int coinChange(int[] coins, int amount) {
        // DP: build dp[] upto amount.
        // dp[i] = min num of coins to form that amount

        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0; // base case

        for(int amt=1; amt < amount+1; amt++) // for each amout, try every single valid coin
        {
            for(int coin : coins)
            {
                if(amt < coin) break; 
                dp[amt] = Math.min(dp[amt], dp[amt-coin] + 1);
            }
        }
        return dp[amount]==amount+1 ? -1 : dp[amount];
    }
}
