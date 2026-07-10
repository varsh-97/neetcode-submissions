/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        // hare-tortoise method
        // curr1, curr2 = head; Move curr1 = curr1.next; curr2 = curr2.next.next
        // if they both meet, then there is a cycle

        if(head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }
               
        return false;
    }
}
