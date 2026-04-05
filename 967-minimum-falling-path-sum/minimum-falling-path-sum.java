class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[]dp=new int[n];
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) dp[i]=matrix[0][i];
        for(int i=1;i<m;i++){
            int prev = Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                int temp=dp[j];
                if(j==0) dp[j]= matrix[i][j]+Math.min(dp[j],dp[j+1]);
                else if(j==n-1) dp[j]= matrix[i][j]+Math.min(prev,dp[j]);
                else dp[j]=matrix[i][j]+Math.min(prev,Math.min(dp[j],dp[j+1]));
                prev=temp;
            }
        }
        for(int i=0;i<n;i++) min=Math.min(min,dp[i]);
        return min;
        
        
        // int m = matrix.length;
        // int n = matrix[0].length;
        // int[][]dp=new int[m][n];
        // int min = Integer.MAX_VALUE;
        // for(int i=0;i<n;i++) dp[0][i]=matrix[0][i];
        // for(int i=1;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(j==0) dp[i][j]= matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j+1]);
        //         else if(j==n-1) dp[i][j]= matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j-1]);
        //         else dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i-1][j+1]));
        //     }
        // }
        // for(int i=0;i<n;i++) min=Math.min(min,dp[m-1][i]);
        // return min;
    }
}