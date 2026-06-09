class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
       // keep closing boundaries from all dirs
       // use 4 var: up, down, left and right

       int up = 0;
       int down = matrix.length - 1;
       int right = matrix[0].length - 1;
       int left = 0; 
       List<Integer> result = new ArrayList<>();

       while(up <= down && left <= right)
       {
            for(int i=left; i<=right; i++) // move left->right
            {
                result.add(matrix[up][i]);
            }
            up++; // remove 1st row

            
            for(int i=up; i <= down; i++) // up -> down
            {
                result.add(matrix[i][right]);
            }
            right--;

            if(up <= down)
            {
            for(int i=right; i >= left; i--) // right -> left
            {
                result.add(matrix[down][i]);
            }
            down--;
            }

            if(left <= right)
            {
            for(int i=down; i >= up; i--)
            {
                result.add(matrix[i][left]);
            }
            left++;
            }
       }
       return result;
    }
}
