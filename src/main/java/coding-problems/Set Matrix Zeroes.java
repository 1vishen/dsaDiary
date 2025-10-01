class Solution {
    public void setZeroes(int[][] matrix) {
        /* for a solution without extra space, we use the 0th row and 0th column 
        as markers to indicate which rows and columns should be zeroed. */

        /* However, there's a critical caveat: if we don't use separate flags to track 
        whether the first row or first column originally contained a zero, we risk 
        misinterpreting the markers. For example, if matrix[0][j] is set to 0 due to 
        a zero found in a lower row, we can't tell whether that zero was originally 
        present in the first row or was placed there as a marker. As a result, we 
        might mistakenly zero out the entire first row or column even if it wasn't 
        supposed to be. */

        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        for (int j = 0; j < colLength; j++) {
            if (matrix[0][j] == 0)
                firstRowHasZero = true;
        }
        for (int i = 0; i < rowLength; i++) {
            if (matrix[i][0] == 0)
                firstColHasZero = true;
        }
        /* make 0th row and col zero if there's any zero in [i][j], 
            starting from 1st row and col, leaving 0th row and col */
        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < colLength; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }

            }
        }

        /* set all elements in entire row as zero if element in 0th col is zero, starting from
         1st row*/
        for (int i = 1; i < rowLength; i++) {
            int j = 0;
            if (matrix[i][0] == 0) {
                while (j < colLength) {
                    matrix[i][j++] = 0;
                }
            }
        }
        /* set all elements in entire col as zero if element in 0th row is zero, starting from
         1st col */
        for (int j = 1; j < colLength; j++) {
            int i = 0;
            if (matrix[0][j] == 0) {
                while (i < rowLength) {
                    matrix[i++][j] = 0;
                }
            }
        }

        // check if both  boolean are true to also make all of 0th row & col as zero
        if (firstColHasZero) {
            for (int i = 0; i < rowLength; i++) {
                matrix[i][0] = 0;
            }
        }
        if (firstRowHasZero) {
            for (int j = 0; j < colLength; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}