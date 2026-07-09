class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSoFar = Integer.MAX_VALUE; 
        int right = 0;
        int left = 1;

        for(int p : piles)
        {
            if(p > right) right = p;
        }

        while(left <= right)
        {
            int mid = left + (right-left) / 2; 
            int hours = 0;

            for(int p : piles)
            {
                hours += (p + mid - 1)/mid; // get the ceil 
            }

            if(hours <= h) 
            {
                minSoFar = Math.min(minSoFar, mid);
                right = mid-1;
            }
            else
            {
                left = mid + 1;
            }
        }

        return minSoFar;
    }
}
