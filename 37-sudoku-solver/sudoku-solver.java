class Solution {
    int check = 0; 
    public void solveSudoku(char[][] board) {
        check = 0; 
        solve(board, 0, 0);
    }
    private void solve(char[][] board, int row, int col) {
        if (row == 9) {
            check = 1;
            return;
        }
        if (board[row][col] != '.') {
            if (col == 8) solve(board, row + 1, 0);
            else solve(board, row, col + 1);
        } else {
            for (char ch = '1'; ch <= '9'; ch++) {
                if (isValid(board, row, col, ch)) {
                    board[row][col] = ch;
                    if (col == 8) solve(board, row + 1, 0);
                    else solve(board, row, col + 1);
                    if (check == 1) return;
                    board[row][col] = '.';
                }
            }
        }
    }
    public boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++){
            if(board[i][col] == c){
                return false; // column check
            }
            if(board[row][i] == c){ // row check
                return false;
            }
            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c){ // 3x3 grid check
                return false;
            }
        }
        return true;
    }
}