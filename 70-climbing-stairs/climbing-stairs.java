class Solution {
    // private int climb(int[] dp,int n){
    //     if(n==1) return 1;
    //     if(n==2) return 2;
    //     if(dp[n]!=0) return dp[n];
    //     return dp[n]=climb(dp,n-1)+climb(dp,n-2);
    // }
    public int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int a=1,b=2;
        for(int i=3;i<=n;i++){
            int c=b;
            b=a+b;
            a=c;
        }
        return b;

        // if(n==1) return 1;
        // if(n==2) return 2;
        // int[] dp=new int[n+1];
        // dp[1]=1;dp[2]=2;
        // for(int i=3;i<=n;i++){
        //     dp[i]=dp[i-1]+dp[i-2];
        // }
        // return dp[n];

        // return climb(dp,n);


        // if(n==1) return 1;
        // if(n==2) return 2;
        // return climbStairs(n-1)+climbStairs(n-2);

    //     int prev1=2;
    //     int prev2=1;
    //     if (n==1) return prev2; 
    //     else if (n==1) return prev1; 
    //     for(int i=3;i<=n;i++){
    //         int temp=prev2;
    //         prev2=prev1;
    //         prev1=prev1+temp;
    //     }
    //     return prev1;
    }
}