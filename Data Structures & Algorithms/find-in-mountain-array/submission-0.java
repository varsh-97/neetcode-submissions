/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        // find peak
        // then binary search on left and then right

        int n = mountainArr.length();
        int peak = findPeak(mountainArr, 0, n-1);

        int res = searchAsc(mountainArr, target, 0, peak); // search left slope
        return res == -1 ? (searchDesc(mountainArr, target, peak+1, n-1)) : res; // else search right slope
    }

    public int findPeak(MountainArray mountainArr, int start, int end)
    {
        while(start < end)
        {
            int mid = start + (end - start) / 2;
            if(mountainArr.get(mid) < mountainArr.get(mid+1)) // we are on the left side
            {
                start = mid+1;
            }
            else // we are on the right side
            {
                end = mid - 1;
            }
        }
        return start; // or end
    }

    public int searchAsc(MountainArray mountainArr, int target, int start, int end)
    {
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            int val = mountainArr.get(mid);

            if(val == target) return mid;
            else if(val < target) start = mid+1;
            else end = mid - 1;
        }
        return -1;
    }

    public int searchDesc(MountainArray mountainArr, int target, int start, int end)
    {
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            int val = mountainArr.get(mid);

            if(val == target) return mid; // reverse condition
            else if(val < target) end = mid-1;
            else start = mid + 1;
        }
        return -1;
    }
}