class Solution {
    public int findDuplicate(int[] nums) {
        // think of it as a linkedList with cycle and we need to find the cyclestart

        int slow = 0;
        int fast = 0;

        do // their meeting point will be inside the cycle
        {
            slow = nums[slow]; // next
            fast = nums[nums[fast]]; // next.next
        } while(slow != fast);

        slow = 0; // reset slow to head
        while(slow != fast) // move each one step at a time
        {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow; // cycle start
    }
}
