class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // return solve(strs, 0, m, n);

        // int len = strs.length;
        // int[][][] dp = new int[len][m + 1][n + 1];
        // for (int i = 0; i < len; i++) {
        //     for (int j = 0; j <= m; j++) {
        //         Arrays.fill(dp[i][j], -1);
        //     }
        // }
        // return solve(strs, 0, m, n, dp);


        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int zeros = 0;
            for (char c : s.toCharArray()) if (c == '0') zeros++;
            int ones = s.length() - zeros;
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max( dp[i][j], 1 + dp[i - zeros][j - ones]);
                }
            }
        }
        return dp[m][n];
    
    }
    private int solve(String[] strs, int i, int m, int n, int[][][] dp) {
        if (i == strs.length) return 0;
        if (dp[i][m][n] != -1) return dp[i][m][n];
        int zeros = countZeros(strs[i]);
        int ones = strs[i].length() - zeros;
        int notTake = solve(strs, i + 1, m, n, dp);
        int take = 0;
        if (zeros <= m && ones <= n) {
            take = 1 + solve(strs, i + 1, m - zeros, n - ones, dp);
        }
        return dp[i][m][n] = Math.max(take, notTake);
    }

    private int solve(String[] strs, int i, int m, int n) {
        if (i == strs.length) return 0;
        int zeros = countZeros(strs[i]);
        int ones = strs[i].length() - zeros;
        int notTake = solve(strs, i + 1, m, n);
        int take=0;
        if (zeros <= m && ones <= n) take = 1 + solve(strs, i + 1, m - zeros, n - ones);
        return Math.max(take, notTake);
    }
    private int countZeros(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') count++;
        }
        return count;
    }
}