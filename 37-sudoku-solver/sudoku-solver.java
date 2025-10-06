class Solution {
    int check = 0; // flag to stop recursion when solution is found

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    // Recursive backtracking function
    private void solve(char[][] board, int row, int col) {
        if (row == 9) { // reached the end → solution found
            check = 1;
            return;
        }

        if (board[row][col] != '.') {
            // Move to next cell
            if (col == 8) solve(board, row + 1, 0);
            else solve(board, row, col + 1);
        } else {
            // Try digits 1-9
            for (char ch = '1'; ch <= '9'; ch++) {
                if (isValid(board, row, col, ch)) {
                    board[row][col] = ch;
                    if (col == 8) solve(board, row + 1, 0);
                    else solve(board, row, col + 1);

                    if (check == 1) return; // solution found → stop recursion

                    board[row][col] = '.'; // backtrack
                }
            }
        }
    }

    // Check if placing 'num' at board[row][col] is valid
    private boolean isValid(char[][] board, int row, int col, char num) {
        // Check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) return false;
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        // Check 3x3 grid
        int sRow = (row / 3) * 3;
        int sCol = (col / 3) * 3;
        for (int i = sRow; i < sRow + 3; i++) {
            for (int j = sCol; j < sCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true; // safe to place
    }
}