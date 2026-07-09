class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // TC: O(n log n), SC: O(n)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> calcDist(b) - calcDist(a));

        for(int[] p : points)
        {
            maxHeap.offer(new int[]{p[0], p[1]});
            if(maxHeap.size() > k) maxHeap.poll();
        }

        int[][] result = new int[k][2];
        int i=0;
        while(!maxHeap.isEmpty())
        {
            result[i] = maxHeap.poll();
            i++;
        }

        return result;
    }

    public int calcDist(int[] p)
    {
        return p[0]*p[0] + p[1]*p[1];
    }
}
