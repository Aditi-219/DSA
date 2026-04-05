class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n];
        int count = 0; int prev = 0;
        for (int i = 0; i < m; i++) {
            prev = 0;
            for (int j = 0; j < n; j++) {
                int temp=dp[j];
                if (i == 0 || j == 0){
                    dp[j] = matrix[i][j];
                }
                else if (matrix[i][j] == 1){
                    dp[j] = Math.min(prev, Math.min(dp[j - 1], dp[j] )) + 1;
                }
                else {
                    dp[j] = 0;
                }
                count += dp[j];
                prev=temp;
            }
        }
        return count;
        
        
        // int m = matrix.length;
        // int n = matrix[0].length;
        // int[][] dp = new int[m][n];
        // int count = 0;
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (i == 0 || j == 0) 
        //             dp[i][j] = matrix[i][j];
        //         else if (matrix[i][j] == 1) 
        //             dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
        //         count += dp[i][j];
        //     }
        // }
        // return count;
    }
}