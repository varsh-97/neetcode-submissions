class Solution {
    public int longestConsecutive(int[] nums) {
        // find the starting point of the chain
        // so, for every num, I will check if there exists a num-1. 
        // If so, this num cannot be the starting point, so skip.
        // else, count++ and look for num+1 and do maxCount
        // T: O(n), SC: O(n) hashset

        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        int maxCount = 1;

        for(int num : nums)
        {
            if(set.contains(num-1)) continue;
            else
            {
                int count = 1;
                while(set.contains(num+1))
                {
                    count++;
                    num = num+1;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}
