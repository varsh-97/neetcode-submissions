class Solution {
    public int leastInterval(char[] tasks, int n) {
        // each cycle will be of len n+1 i.e. the task + n idle time
        // TC: O(n log k) for k items in tasks, SC: O(k)

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a); // maxHeap
        int[] freq = new int[26];

        for(char t : tasks)
        {
            freq[t - 'A']++;
        }

        for(int f : freq)
        {
            if(f > 0) queue.offer(f); 
        }

        
        int cycle = 0;
        while(!queue.isEmpty())
        {
            int windowLen = n+1;
            List<Integer> temp = new ArrayList<>();

            while(windowLen > 0 && !queue.isEmpty())
            {
                int curr = queue.poll();
                if(curr-1 > 0) temp.add(curr-1);

                cycle++;
                windowLen--;
            }

            for(int t : temp) queue.offer(t);

            if(!queue.isEmpty()) cycle += windowLen; // adding idle time
        }        
        return cycle;
    }
}
