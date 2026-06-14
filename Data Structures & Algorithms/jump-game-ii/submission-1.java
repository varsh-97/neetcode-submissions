class Solution {
    public int jump(int[] nums) {
        // jumping from j->1: dp[i] = min jumps required to get to j + 1, so, dp[j]+1
        // at every index, calculate the number of jumps we can do from that index and if the res index is n-1
        // fill the dp[] with max int and return the dp[n-1]
        // TC: O(n)

        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=0; i<nums.length; i++)
        {
            int val = nums[i]; // total jumps from that index
            for(int j=1; j<=val; j++)
            {
                if(i+j < nums.length)
                {
                    dp[i+j] = Math.min(dp[i+j], dp[i]+1);
                    if(i+j == nums.length - 1) return dp[i+j];
                }
            }
        }
        return dp[nums.length - 1];
    }
}
