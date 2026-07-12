class Solution {
    public boolean canJump(int[] nums) {
        // check the farthest I can go from each index and if i > farthest, return false. Since
        // I cannot even move to the current index.
        // else, return true
        // TC: O(n), SC: O(1)

        int farthest = 0;

        for(int i=0; i < nums.length; i++)
        {
          if(farthest < i) return false; // check if curr index is reachable
          farthest = Math.max(farthest, i+nums[i]); // update farthest

          if(farthest >= nums.length-1) return true;
          
        }

        return true;
    }
}
