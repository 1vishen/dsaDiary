class NumMatrix {
    /*
     * we can build a prefix matrix that can be used to calc all area by
     * iterating through the matrix and at each point we calc area from starting to
     * that point
     */
    int[][] prefixArea;
    int currArea;
    int otherRowArea;

    public NumMatrix(int[][] matrix) {
        prefixArea = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                /* i == 0 means only a horizontal single row rect is formed */
                if (i == 0) {
                    prefixArea[i][j] = (j == 0) ? matrix[i][j] : matrix[i][j] + prefixArea[i][j - 1];
                }
                /*
                 * if i != 0 then that means we need to take into account prev
                 * row prefix sum so that rect of all shapes can be formed and they
                 * need to add sum of prev row's as well
                 */
                else {
                    /*
                     * similar logic for j where in 1st row we dont care about
                     * sum to the left but in subsequent rows we do
                     */
                    if (j == 0) {
                        prefixArea[i][j] = matrix[i][j] + prefixArea[i - 1][j];
                    }
                    /*
                     * if j != 0 then that means we need to take are of left and
                     * top area both but in doing that we will count [i-1][j-1]
                     * rect's area twice so we need to sub it
                     */
                    else {
                        prefixArea[i][j] = matrix[i][j] + prefixArea[i - 1][j] +
                                prefixArea[i][j - 1] - prefixArea[i - 1][j - 1];
                    }
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        /*
         * Ques:
         * why its absolute not relative we need to sub rect before left top and
         * left bottom and top left, top right and then add back the rect above top
         * left. If we just do -1 then if rect is more than 1 unit tall or wide it
         * will sub from inside the rect itself.
         * 
         * Ans:
         * oh I get it, the prev index will have sum of rect formed by it being
         * bottom right corner.
         * The prefix matrix stores absolute cumulative sums from (0,0) to (i,j),
         * so subtraction must use absolute indices (row1-1, col1-1) rather than
         * relative offsets.
         */

        int total = prefixArea[row2][col2];
        /*
         * we need to check if we are dealing with top row/leftmost column if
         * yes then we need to sub nothing
         */
        int top = (row1 == 0) ? 0 : prefixArea[row1 - 1][col2];
        int left = (col1 == 0) ? 0 : prefixArea[row2][col1 - 1];
        int doubleSub = (row1 == 0 || col1 == 0) ? 0 : prefixArea[row1 - 1][col1 - 1];

        return total - (top + left) + doubleSub;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
