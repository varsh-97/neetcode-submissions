class Solution {
    public int maxSubArray(int[] nums) {
        // uses kadane's algo: decide if we have to continue the seq or start a new one
        int currSum = nums[0];
        int maxSum = nums[0];

        for(int i=1; i<nums.length; i++)
        {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
