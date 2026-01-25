class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int row = 0; row < m; row++) {
            if (grid[row][0] == 0) {
                for (int col = 0; col < n; col++) {
                    grid[row][col] = 1 - grid[row][col];
                }
            }
        }
        for (int j = 1; j < n; j++) {
            int ocnt = 0, zcnt = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) ocnt++;
                else zcnt++;
            }
            if (ocnt < zcnt){
                for (int i = 0; i < m; i++) {
                    grid[i][j] ^= 1;
                }
            }
        }
        int sum= 0, pow=1;
        for (int j = n-1; j >=0; j--) {
            int one = 0;
            for (int i = 0; i < m; i++) {
                if(grid[i][j]==1) one++;
            }
            sum+=one*pow;
            pow*=2;
        }
        return sum;
    }
}