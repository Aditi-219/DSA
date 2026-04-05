public class Solution { 
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String s2="";
        for(int i=n-1;i>=0;i--) s2+=s.charAt(i);
        int[]dp=new int[n+1];
        for(int i=1;i<=n;i++){
            int prev=0;
            for(int j=1;j<=n;j++){
                int temp=dp[j];
                if(s.charAt(i-1)==s2.charAt(j-1)){
                    dp[j]=1+prev;
                }else{
                   dp[j]=Math.max(dp[j], dp[j-1]); 
                }
                prev=temp;
            }
        }
        return dp[n];


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
    }
}