class Solution {
    public int maxSumDivThree(int[] nums) {
        // int[] dp = new int[3];
        // dp[0] = 0;
        // for (int num : nums) {
        //     int[] temp = dp.clone();
        //     for (int sum:temp) {
        //         int newSum=sum+rem;
        //         int newRem = newSum % 3;
        //         dp[newRem] = Math.max(dp[newRem],newSum);
        //     }
        // }
        // return dp[0];

        int n=nums.length;
        int dp[][]= new int[n+1][3];
        dp[n][0]=0;
        dp[n][2]=dp[n][1]=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            for(int rem=0;rem<=2;rem++){
                int newRem= (nums[i]+rem)%3;
                dp[i][rem]= Math.max( dp[i+1][rem] , nums[i]+dp[i+1][newRem]);
            }
        }
        return dp[0][0];


        // int n=nums.length;
        // int[][]dp=new int[n][3];
        // for (int[] row : dp) Arrays.fill(row, -1);
        // return solve(nums,0,0,dp);
    }
    // private int solve(int[]nums,int i,int rem,int[][]dp){
    //     if(i==nums.length) return rem==0?0:Integer.MIN_VALUE;
    //     if(dp[i][rem]!=-1) return dp[i][rem];
    //     int left=solve(nums,i+1,rem,dp);
    //     int newrem=(rem+nums[i])%3;
    //     int take=nums[i]+solve(nums,i+1,newrem,dp);
    //     return dp[i][rem]=Math.max(take,left);
    // }
}