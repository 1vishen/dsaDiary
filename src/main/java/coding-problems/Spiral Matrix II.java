class Solution {
    public int[][] generateMatrix(int n) {
        // making matrix
        int[][] matrix = new int[n][n];

        // choosing 4 posn for 4 sides of spiral transversal
        int top = 0;
        int right = n - 1;
        int bottom = n - 1;
        int left = 0;

        // to count natural no from 1 to n^2
        int i = 1;

        /* transversing, here col & row are the ones that are changing while transversing.
            Important: Use <= in while and if conditions to ensure the center cell is filled 
            in odd-sized matrices. If we use only <, the loop exits before reaching the final
            single row or column, causing the center cell to remain unfilled (e.g., matrix[1]
            [1] in a 3x3 matrix). */
        while (top <= bottom && left <= right) {
            /* top <= bottom && left <= right in all 4 if to avoid extra additions in 
                odd n matrices */
            if (top <= bottom && left <= right) {
                for (int col = left; col <= right; col++) {
                    matrix[top][col] = i++;
                }
                top++;
            }
            if (top <= bottom && left <= right) {
                for (int row = top; row <= bottom; row++) {
                    matrix[row][right] = i++;
                }
                right--;
            }
            if (top <= bottom && left <= right) {
                for (int col = right; col >= left; col--) {
                    matrix[bottom][col] = i++;
                }
                bottom--;
            }
            if (top <= bottom && left <= right) {
                for (int row = bottom; row >= top; row--) {
                    matrix[row][left] = i++;
                }
                left++;
            }
        }
        return matrix;
    }
}