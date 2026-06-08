class Solution {
    public int[] twoSum(int[] nums, int target) {
        // use two pointers if array is sorted: O(n), O(1)
        // use hashmap if array is unsorted: O(n), O(n)

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++)
        {
            int val = target - nums[i];
            if(map.containsKey(val))
            {
                return new int[]{map.get(val), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
