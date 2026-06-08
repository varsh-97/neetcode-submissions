class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort intervals based on start times, if same start times, pick the smallest end time
        // O(n log n)
        // iterate over each index+1 and check if i-1 end time < ith start time , if not merge

        Arrays.sort(intervals, (a,b) -> {
        if(a[0] == b[0]) return a[1]-b[1];
        return a[0] - b[0];
    }); 

        List<int[]> result = new ArrayList<>();
        int[] pos = intervals[0];

        for(int i=1; i<intervals.length; i++)
        {
            if(intervals[i][0] <= pos[1]) // needs to be merged
            {
                pos[1] = Math.max(intervals[i][1], pos[1]);
            }
            else
            {
                result.add(pos);
                pos = intervals[i];
            }
        }
        result.add(pos); // adding last interval
        return result.toArray(new int[result.size()][]);
    }
}
