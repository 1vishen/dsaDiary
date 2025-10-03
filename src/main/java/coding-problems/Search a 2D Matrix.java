class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /* - since each row’s first element is greater than the last of the previous row, the
         matrix behaves like a flattened sorted array. So, First binary search on the first
          column to find the row where the target might lie. Then binary search
           within that row. */

        if (target < matrix[0][0] ||
                target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        }

        // defining pointers for 0th column 
        int topColP = 0;
        int bottomColP = matrix.length - 1;
        int rowIndexToSearch = -1;

        while (topColP <= bottomColP) {
            int mid = topColP + (bottomColP - topColP) / 2;

            // if target is in 0th col itself
            if (matrix[mid][0] == target)
                return true;
            else if (matrix[mid][0] > target) {
                bottomColP = mid - 1;
                /* We should only update rowIndexToSearch when matrix[mid][0] < target,
                because that means the target could potentially lie in this row.
                If matrix[mid][0] > target, the target must be in a previous row,
                but we can't assume it's in mid - 1 without confirmation.
                So we let the binary search naturally narrow down the correct row
                and only update rowIndexToSearch when we're sure the row might contain the
                target. */
            } else if (matrix[mid][0] < target) {
                topColP = mid + 1;
                // this row might contain the target
                rowIndexToSearch = mid; 
            }
        }

        // if rowIndexToSearch gets out of bounds
        if(rowIndexToSearch < 0 || rowIndexToSearch >= matrix.length) return false;

        // how we know which row holds our target by rowIndexToSearch, so do B.S. in that row
        int leftSelectedColP = 0;
        int rightSelectedColP = matrix[0].length - 1;

        while (leftSelectedColP <= rightSelectedColP) {
            int mid = leftSelectedColP + (rightSelectedColP - leftSelectedColP) / 2;

            if (matrix[rowIndexToSearch][mid] == target)
                return true;
            else if (matrix[rowIndexToSearch][mid] > target)
                rightSelectedColP = mid - 1;
            else if (matrix[rowIndexToSearch][mid] < target)
                leftSelectedColP = mid + 1;
        }
        return false;
    }
}