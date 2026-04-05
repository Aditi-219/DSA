public class Solution { 
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = n - 2; i >= 0; i--) {
            int prev = 0;
            for (int j = i + 1; j < n; j++) {
                int temp = dp[j];
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = prev + 2;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }
        return dp[n - 1];
    

        // int n = s.length();
        // int[][] dp = new int[n][n];
        // for (int i = 0; i < n; i++) dp[i][i] = 1;
        // for (int len = 2; len <= n; len++) {
        //     for (int i = 0; i <= n - len; i++) {
        //         int j = i + len - 1;
        //         if (s.charAt(i) == s.charAt(j)) {
        //             dp[i][j] = 2 + dp[i + 1][j - 1];
        //         } else {
        //             dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        //         }
        //     }
        // }
        // return dp[0][n - 1];


        //int n = s.length();
        // String s2 = new StringBuilder(s).reverse().toString();
        // int[]dp=new int[n+1];
        // for(int i=1;i<=n;i++){
        //     int prev=0;
        //     for(int j=1;j<=n;j++){
        //         int temp=dp[j];
        //         if(s.charAt(i-1)==s2.charAt(j-1)){
        //             dp[j]=1+prev;
        //         }else{
        //            dp[j]=Math.max(dp[j], dp[j-1]); 
        //         }
        //         prev=temp;
        //     }
        // }
        // return dp[n];
    }
}