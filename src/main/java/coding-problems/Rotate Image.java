class Solution {
    public void rotate(int[][] matrix) {
        int rowSize = matrix.length;
        //assuming all member arrays are of same size i.e. square matrix
        int colSize = matrix[0].length;
        /*
        here i is row of matrix / each member array and 
        j is col of matrix / each element in each member array
        */
        for(int i = 0; i < rowSize / 2; i++) {

            for(int j = i; j < colSize - 1 - i ; j++) {
                // Read original values from fixed positions
                int temp1 = matrix[i][j];                         // top-left
                int temp2 = matrix[j][colSize - 1 - i];           // top-right
                int temp3 = matrix[rowSize - 1 - i][colSize - 1 - j]; // bottom-right
                int temp4 = matrix[rowSize - 1 - j][i];           // bottom-left

                // Rotate clockwise
                matrix[i][j] = temp4;                             // bottom-left → top-left
                matrix[j][colSize - 1 - i] = temp1;               // top-left → top-right
                matrix[rowSize - 1 - i][colSize - 1 - j] = temp2; // top-right → bottom-right
                matrix[rowSize - 1 - j][i] = temp3;               // bottom-right → bottom-left
            }
        }
    }
}