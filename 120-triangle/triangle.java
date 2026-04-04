class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[]dp=new int[n];
        for(int i=0;i<n;i++) dp[i]=triangle.get(n-1).get(i);
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[j]=triangle.get(i).get(j)+Math.min(dp[j],dp[j+1]);
            }
        }
        return dp[0];


        // int n=triangle.size();
        // int[][]dp=new int[n][n];
        // dp[0][0]=triangle.get(0).get(0);
        // for(int i=1;i<n;i++) dp[i][0]=dp[i-1][0]+triangle.get(i).get(0);
        // for(int i=1;i<n;i++) dp[i][i]=dp[i-1][i-1]+triangle.get(i).get(i);
        // for(int i=1;i<n;i++){
        //     for(int j=1;j<i;j++){
        //         dp[i][j]=triangle.get(i).get(j)+Math.min(dp[i-1][j-1],dp[i-1][j]);
        //     }
        // }
        // int ans = Integer.MAX_VALUE;
        // for(int j = 0; j < n; j++) ans = Math.min(ans, dp[n-1][j]);
        // return ans;


        // int row = triangle.size();
        // int[] dp = new int[row];
        // for (int i = 0; i < row; i++) {
        //     dp[i] = triangle.get(row - 1).get(i);
        // }
        // for (int r = row-2; r >= 0; r--) {
        //     for (int c = 0; c <= r; c++) {
        //         dp[c] =triangle.get(r).get(c) + Math.min(dp[c], dp[c+1]);
        //     }
        // }
        // return dp[0];        
    }
}