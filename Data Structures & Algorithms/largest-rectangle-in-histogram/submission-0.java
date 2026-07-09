class Solution {
    public int largestRectangleArea(int[] heights) {
        // use a stack that is increasing and if curr height < stack.peek(), then we hit the right boundary
        // keep popping and calculating the area with right = i, height = stack.pop() and left = satck.peek()
        
        int maxArea = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0; i<=heights.length; i++)
        {
            int currHeight = (i == heights.length) ? 0 : heights[i];

            while(!deque.isEmpty() && heights[deque.peek()] > currHeight)
            {
                int height = heights[deque.pop()];
                int right = i;
                int left = deque.isEmpty() ? -1 : deque.peek(); 

                maxArea = Math.max(maxArea, height * (right - left - 1));
            }
            deque.push(i);
        }
        return maxArea;
    }
}
