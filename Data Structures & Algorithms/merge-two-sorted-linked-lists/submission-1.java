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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // have two listNodes l1 and l2 that iterates over each list
        // if(l1.val < l2.val) then curr.next = l1 else curr.next = l2
        // if there are elements remaining in 1 list, add them to the end of curr
        // TC: O(m + n), SC: O(1)

        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy; 

        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val) 
            {
                curr.next = l1;
                l1 = l1.next;
            }
            else
            {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if(l1 != null)
        {
            curr.next = l1;
        }

        if(l2 != null)
        {
            curr.next = l2;
        }

        return dummy.next;
    }
}