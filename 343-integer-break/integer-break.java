class Solution {
    public int integerBreak(int n) {
        if(n==2|| n==1) return 1;
        int max=0;
        int []dp=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;dp[1]=1;
        // for(int i=1;i<n;i++){
        //     int breaker=i*integerBreak(n-i);
        //     int noBreak=i*(n-i);
        //     max = Math.max(max, Math.max(breaker, noBreak));
        // }
        return solve(n,dp);
    }
    private int solve(int n, int[]dp){
        if(n==2|| n==1) return 1;
        int max=0;
        if(dp[n]!=-1) return dp[n];
        for(int i=1;i<n;i++){
            int breaker=i*solve(n-i,dp);
            int noBreak=i*(n-i);
            max = Math.max(max, Math.max(breaker, noBreak));
        }
        return dp[n]=max;
    }
}