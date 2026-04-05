public class Solution {
    private int opr(String s1, String s2, int m, int n, int[][]dp){
        if(m==0) return n;
        if(n==0) return m;
        if(s1.charAt(m-1)==s2.charAt(n-1)) return opr(s1,s2,m-1,n-1,dp);
        if(dp[m][n]!=-1) return dp[m][n];
        int del=opr(s1,s2,m-1,n,dp);
        int rep=opr(s1,s2,m-1,n-1,dp);
        int ins=opr(s1,s2,m,n-1,dp);
        return dp[m][n]=1+Math.min(del,Math.min(rep,ins));
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][]dp=new int[m+1][n+1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return opr(word1,word2,m,n,dp);
        
        
        // int[][] dp = new int[m + 1][n + 1];
        // for (int i = 0; i <= m; i++) dp[i][0] = i;
        // for (int j = 0; j <= n; j++) dp[0][j] = j;
        // for (int i = 1; i <= m; i++) {
        //     for (int j = 1; j <= n; j++) {
        //         if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
        //             dp[i][j] = dp[i - 1][j - 1];
        //         } else {
        //             dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
        //         }
        //     }
        // }
        // return dp[m][n];
    }
}