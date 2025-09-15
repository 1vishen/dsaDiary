class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0)
            return ans;

        int rowSize = matrix.length, colSize = matrix[0].length;
        int top = 0; // starting row element
        int bottom = rowSize - 1; // ending row element
        int left = 0; // starting col element
        int right = colSize - 1; // ending col element

        while (top <= bottom && left <= right) {
            // Left to Right
            if (top <= bottom && left <= right) {
                for (int changingCol = left; changingCol <= right; changingCol++) {
                    ans.add(matrix[top][changingCol]);
                }
                top++;
            }

            // top to bottom
            if (top <= bottom && left <= right) {
                for (int changingRow = top; changingRow <= bottom; changingRow++) {
                    ans.add(matrix[changingRow][right]);
                }
                right--;
            }

            // right to left
            if (top <= bottom && left <= right) {
                for (int changingCol = right; changingCol >= left; changingCol--) {
                    ans.add(matrix[bottom][changingCol]);
                }
                bottom--;
            }

            // bottom to top
            if (top <= bottom && left <= right) {
                for (int changingRow = bottom; changingRow >= top; changingRow--) {
                    ans.add(matrix[changingRow][left]);
                }
                left++;
            }
        }
        return ans;
    }
}