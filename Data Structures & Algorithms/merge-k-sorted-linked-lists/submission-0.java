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
    public ListNode mergeKLists(ListNode[] lists) {
        // Use a MinHeap and push the heads of the lists
        // after every poll(), if the element.next exists, then push it
        // TC: O(n log k), SC: O(k)

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a.val, b.val));

        for(ListNode l : lists)
        {
            if(l != null) minHeap.offer(l);
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while(!minHeap.isEmpty())
        {
            ListNode curr = minHeap.poll();
            if(curr != null) 
            {
                tail.next = curr;
                tail = tail.next;
            }
            if(curr.next != null) minHeap.offer(curr.next);
        }

        return dummy.next;
    }
}
