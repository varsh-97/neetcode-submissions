class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for(int s : stones)
        {
            maxHeap.offer(s);
        }

        while(maxHeap.size() > 1)
        {
            int val1 = maxHeap.poll();
            int val2 = maxHeap.poll();

            if(val1 != val2) maxHeap.offer(val1 - val2);
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
