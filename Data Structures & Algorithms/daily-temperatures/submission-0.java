class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       // use a minHeap and push the index
       // at each temp, check if the minHeap.peek() is smaller, and if so, poll() and
       // update the res[index] with the difference
       // TC: O(n log n), SC: O(n)

       int[] result = new int[temperatures.length];
       PriorityQueue<Integer> minHeap = new PriorityQueue<>(
        (a,b) -> temperatures[a] - temperatures[b]
       ); 

       for(int i=0; i<temperatures.length; i++)
       {
                while(!minHeap.isEmpty() && temperatures[minHeap.peek()] < temperatures[i])
                {
                    int idx = minHeap.poll();
                    result[idx] = i - idx;
                }
            minHeap.offer(i);
       }
       return result;
    }
}
