class Solution {
    public void setZeroes(int[][] matrix) {
        // store all original locations where zeros are
        List<Integer> rowIndexArr =  new ArrayList<>();
        List<Integer> colIndexArr = new ArrayList<>();

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rowIndexArr.add(i);
                    colIndexArr.add(j);
                }
            }
        }

        // now using those original locations make entire row/col zero
        for(int i : rowIndexArr) {
            setRowZero(i, matrix);
        }
        for(int j : colIndexArr) {
            setColZero(j, matrix);
        }
    }

    private void setColZero(int element, int[][] matrix) {
        int lengthOfRow = matrix.length;
        for(int i = 0; i < lengthOfRow; i++) {
            matrix[i][element] = 0;
        }
    }

    private void setRowZero(int element, int[][] matrix) {
        // assuming all col are of same length
        int lengthOfCol = matrix[0].length;
        for(int i = 0; i < lengthOfCol; i++) {
            matrix[element][i] = 0;
        }
    }
}