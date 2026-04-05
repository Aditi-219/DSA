public class Solution {
    // private int decode(String s, int i,int[]dp){
    //     if (i == s.length()) return 1;
    //     if (s.charAt(i) == '0') return 0;
    //     if(dp[i]!=-1) return dp[i];
    //     int ways=decode(s,i+1,dp);
    //     if (i + 1 < s.length()) {
    //         int twoDigit = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
    //         if (twoDigit >= 10 && twoDigit <= 26) {
    //             ways += decode(s, i + 2,dp);
    //         }
    //     }
    //     return dp[i]=ways;
    // }
    public int numDecodings(String s) {
        int[]dp=new int[s.length()+1];
        dp[0]=1;
        dp[1]=s.charAt(0) != '0' ? 1 : 0;
        for(int i=2;i<=s.length();i++){
            if (s.charAt(i - 1) != '0')dp[i]+=dp[i-1];
            int twoDigit = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];


        // Arrays.fill(dp,-1);
        // return decode(s,0,dp);

        // if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        // int n = s.length();
        // int[] dp = new int[n + 1];
        // dp[0] = 1;        
        // for (int i = 1; i <= n; i++) {
        //     if (s.charAt(i - 1) != '0') {
        //         dp[i] += dp[i - 1];
        //     }
        //     if (i > 1 && (s.charAt(i - 2) == '1' || ( s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))) {
        //         dp[i] += dp[i - 2];
        //     }
        // }
        // return dp[n];
    }
}