/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        // sort intervals by their start times.
        // we need to track the current meetings and rooms they hold. 
        // use a minHeap. For every interval, if the currInterval starts after the smallest endTime in the heap, we can reuse that room.
        // so, pop and push this newInterval end time.
        // else, we need a new room , so , push the newInterval end time. 
        // the max of heap size gives the result.

        if(intervals.size() == 0 || intervals == null) return 0; // handle edge case
        intervals.sort((a,b) -> Integer.compare(a.start, b.start)); // sort arrays by their start times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // min heap
        minHeap.offer(intervals.get(0).end); // push the 1st interval into heap
        int heapSize = 1; 

        for(int i = 1; i < intervals.size(); i++)
        {
            if(intervals.get(i).start < minHeap.peek()) // currInterval starts before the smallest meeting ends. So, we need new room
            {
                minHeap.offer(intervals.get(i).end); // add the new interval to heap
                heapSize = Math.max(heapSize, minHeap.size()); // tracks the max heap size
            }
            else // we can reuse the smallest endtime room
            {
                minHeap.poll(); // poll() the smallest meeting room
                minHeap.offer(intervals.get(i).end); // add curr end to heap
            }
        }

        return heapSize;

    }
}
