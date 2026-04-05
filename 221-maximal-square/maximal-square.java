class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n];
        int max = 0, prev=0, temp=0;
        for (int i = 0; i < m; i++) {
            prev=0;
            for (int j = 0; j < n; j++) {
                temp=dp[j];
                if(matrix[i][j]=='1'){
                    if (i == 0 || j == 0)
                        dp[j] = 1;
                    else
                        dp[j] = Math.min(prev, Math.min(dp[j - 1], dp[j])) + 1;
                    max=Math.max(max,dp[j]*dp[j]);
                } else dp[j]=0;
                prev=temp;
            }
        }
        return max;


        // int m = matrix.length;
        // int n = matrix[0].length;
        // int[][] dp = new int[m][n];
        // int max = 0;
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if(matrix[i][j]=='1'){
        //             if (i == 0 || j == 0)
        //                 dp[i][j] = 1;
        //             else
        //                 dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
        //             max=Math.max(max,dp[i][j]*dp[i][j]);
        //         }
        //     }
        // }
        // return max;
    }
}