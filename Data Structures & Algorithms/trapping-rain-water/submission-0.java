class Solution {
    public int trap(int[] height) {
        // two-pointer approach
        // keep adding to water and update and rightMax, leftMax, water = max - index
        // O(n), O(1)

        int water = 0; 
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0, rightMax = 0;

        while(left <= right)
        {
            if(height[left] < height[right]) // total water bounded by smaller side
            {
                // update leftMax, calculate water and left++
                if(height[left] > leftMax)
                {
                    leftMax = height[left];
                }
                water += leftMax - height[left];
                left++;
            }
            else
            {
                if(height[right] > rightMax)
                {
                    rightMax = height[right];
                }
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
}
