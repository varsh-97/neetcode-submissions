class Solution {
    public boolean hasDuplicate(int[] nums) {
        // use hashset
        // T: O(n), S: O(n)

        Set<Integer> set = new HashSet<>();
        for(int n : nums)
        {
            if(set.contains(n)) return true;
            set.add(n);
        }
        return false;
    }
}