class Solution {
    public int maxSumDivThree(int[] nums) {
        int n=nums.length;
        int[][]dp=new int[n][3];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(nums,0,0,dp);
    }
    private int solve(int[]nums,int i,int rem,int[][]dp){
        if(i==nums.length) return rem==0?0:Integer.MIN_VALUE;
        if(dp[i][rem]!=-1) return dp[i][rem];
        int left=solve(nums,i+1,rem,dp);
        int newrem=(rem+nums[i])%3;
        int take=nums[i]+solve(nums,i+1,newrem,dp);
        return dp[i][rem]=Math.max(take,left);
    }
}