class Solution {
    public void setZeroes(int[][] matrix) {
        // use the 0th row and 0th col as sticky notes
        // to avoid matrix[0][0] confusion, use firstCol boolean if any val in the 0th col is zero
        // TC: O(m * n), SC: O(1)

        boolean firstCol = false;
        int r = matrix.length;
        int c = matrix[0].length;

        // find the 0s and mark the r,0 and 0,c as zero
        for(int i = 0; i < r; i++)
        {
            if(matrix[i][0] == 0) // if first col has any zero
            {
                firstCol = true;
            }

            for(int j = 1; j < c; j++)
            {
                if(matrix[i][j] == 0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // traverse the matrix and fill the inner array
        for(int i = 1; i < r; i++)
        {
            for(int j = 1; j < c; j++)
            {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                {
                    matrix[i][j] = 0;
                }
            }
        }

        // account for first row
        if(matrix[0][0] == 0)
        {
            for(int i = 0; i < c; i++)
            {
                matrix[0][i] = 0;
            }
        }

        // accounting for the first col
        if(firstCol)
        {
            for(int i = 0; i<r; i++)
            {
                matrix[i][0] = 0;
            }
        }
    }
}
