class Solution {
    public int maxArea(int[] heights) {
        // two-pointers
        // O(n), O(1)

        int left = 0;
        int right = heights.length-1;
        int maxArea = 0;
        int leftMax = 0;
        int rightMax = 0;

        while(left <= right)
        {
            int water = 0;
            if(heights[left] < heights[right]) // update leftMax, calc water and move left
            {
                if(leftMax < heights[left]) leftMax = heights[left];
                water = leftMax * (right - left); // bounded by smaller height  
                left++;
            }
            else // update rightMax, calc water, move right
            {
                if(rightMax < heights[right]) rightMax = heights[right];
                water = rightMax * (right-left);
                right--;
            }
            maxArea = Math.max(maxArea, water);
        }
        return maxArea;
    }
}
