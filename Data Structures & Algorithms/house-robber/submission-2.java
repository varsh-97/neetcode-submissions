class Solution {
    public int rob(int[] nums) {
        // at each index, I can choose to pick/skip
        // dp[i] = max val upto that house
        // if I pick, then, dp[i] = dp[i] + dp[i-2] as I cannot rob the i-1 house
        // if I skip, dp[i] = dp[i-1]
        // dp[i] = Math.max(dp[rob], dp[skip])

        int[] dp = new int[nums.length];
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        dp[0] = nums[0]; // base case
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++)
        {
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]); // pick or skip
        }
        return dp[nums.length-1];
    }
}
