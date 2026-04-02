class Solution {
    // private int mincost(int[]cost,int n,int[]dp){
    //     if(n==0||n==1) return cost[n];
    //     if(dp[n]!=0) return dp[n];
    //     return dp[n]=cost[n]+Math.min(
    //         mincost(cost,n-1,dp),
    //         mincost(cost,n-2,dp)
    //     );
    // }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int a=cost[0];
        int b=cost[1];
        for(int i=2;i<n;i++){
            int c=b;
            b=cost[i]+Math.min(a,c);
            a=c;
        }
        return Math.min(a,b);


        // int n=cost.length;
        // int []dp=new int[n];
        // dp[0]=cost[0];
        // dp[1]=cost[1];
        // for(int i=2;i<n;i++){
        //     dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
        // }
        // return Math.min(dp[n-1],dp[n-2]);
 
        // return Math.min(mincost(cost,n-1,dp),mincost(cost,n-2,dp));
    }
}