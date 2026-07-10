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
    public ListNode reverseList(ListNode head) {
        // use 3 pointers: prev, curr and next
        // prev = null, curr = head, next = curr.next

        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) // save, reverse and move forward
        {
            ListNode next = curr.next; // save
            curr.next = prev; // reverse
            prev = curr; // move fwd
            curr = next; 
        }

        return prev; 
    }
}
