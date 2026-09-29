class Solution {
    int m, n;
    Boolean[][][] memo;
    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if ((m + n) % 2 == 0) return false;
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false;
        memo = new Boolean[m][n][m + n];
        return dfs(grid, 0, 0, 0);
    }
    private boolean dfs(char[][] grid, int i, int j, int balance) {
        balance+=grid[i][j]=='('? 1:-1;
        if (balance < 0) return false;
        if (balance > (m - 1 - i) + (n - 1 - j)) return false;
        if (i == m - 1 && j == n - 1) return balance == 0;
        if (memo[i][j][balance] != null) return memo[i][j][balance];
        if (i + 1 < m && dfs(grid, i + 1, j, balance)) return memo[i][j][balance] = true;
        if (j + 1 < n && dfs(grid, i, j + 1, balance)) return memo[i][j][balance] = true;
        return memo[i][j][balance] = false;
    }
}