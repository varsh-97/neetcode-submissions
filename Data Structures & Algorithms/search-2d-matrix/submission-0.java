class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int n = matrix.length; // row
       int m = matrix[0].length; // col
       int left = 0;
       int right = m * n - 1; // 0..m*n-1

       while(left <= right)
       {
            int mid = left + (right-left) / 2;
            int nr = mid / m;
            int nc = mid % m;

            if(matrix[nr][nc] == target) return true;
            else if(matrix[nr][nc] < target) left = mid+1;
            else right = mid-1;
       }
       return false;
    }
}
