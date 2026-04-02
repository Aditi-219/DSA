class Solution {
    // private int rober(int[]nums, int n, int[]dp){
    //     if(n==0) return nums[0];
    //     if(n == 1) return Math.max(nums[0], nums[1]);
    //     if(dp[n]!=-1) return dp[n]; 
    //     int take=nums[n]+rober(nums, n-2,dp);
    //     int skip=rober(nums,n-1,dp);
    //     return dp[n]=Math.max(take,skip);
    // }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int []dp=new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0], nums[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        return dp[n-1];

        // return rober(nums,n-1,dp);

        // if (nums.length == 0) return 0;
        // int prev1 = 0;
        // int prev2 = 0;
        // for (int num : nums) {
        //     int curr = Math.max(num + prev2, prev1);
        //     prev2 = prev1;
        //     prev1 = curr;
        // }
        // return prev1;
    }
}