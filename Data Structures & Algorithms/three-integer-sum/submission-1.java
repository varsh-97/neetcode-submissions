class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort the array -> O(n log n)
        // two-pointer approach by fixing an element: O(n log n)
        // TC: O(n^2), SC: O(1)

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++) // go upto len - 2
        {
            if(i > 0 && nums[i] == nums[i-1]) continue; 

            int left = i+1; // two-pointer to find complement sum
            int right = nums.length-1;
            int target = -nums[i]; 

            while(left < right)
            {
                int sum = nums[left] + nums[right];

                if(target == sum)
                {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // skip duplicates in left
                    while(left < right && nums[left] == nums[left-1])
                    {
                        left++;
                    }
                    // skip duplicates in right
                    while(left < right && nums[right] == nums[right+1])
                    {
                        right--;
                    }
                }
                else if(sum < target)
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }
        }
        return result;
    }
}
