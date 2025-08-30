class Solution {
    public boolean isValidSudoku(char[][] board) {
        // checking rows
        for(int i = 0; i < 9; i++) {
        Set<Character> checkDup = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.' && !checkDup.add(board[i][j])) return false;
            }
        }

        //checking cols
        for(int j = 0; j < 9; j++) {
        Set<Character> checkDup2 = new HashSet<>();
            for(int i = 0; i < 9; i++) {
                if(board[i][j] != '.' && !checkDup2.add(board[i][j])) return false;
            }
        }

        //checking mini squares
        if(
            !miniSq(0,0,board) ||
            !miniSq(0,3,board) ||
            !miniSq(0,6,board) ||

            !miniSq(3,0,board) ||
            !miniSq(3,3,board) ||
            !miniSq(3,6,board) ||

            !miniSq(6,0,board) ||
            !miniSq(6,3,board) ||
            !miniSq(6,6,board)
        ) return false;

        return true;
    }

    public boolean miniSq(int x, int y, char[][] board) {
        Set<Character> checkDup3 = new HashSet<>();
        for(int m = 0; m < 3; m++) {
            for(int n = 0; n < 3; n++) {
                if(board[m + x][n + y] != '.' && 
                    !checkDup3.add(board[m + x][n + y])) return false;
            }
        }
        return true;
    }
}