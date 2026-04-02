class Solution {
    // private int rober(int[]nums,int i,int n){
    //     if(n==i) return nums[i];
    //     if(i>n) return 0;
    //     int take=nums[n]+rober(nums,i, n-2);
    //     int skip=rober(nums,i,n-1);
    //     return Math.max(take,skip);
    // }
    // private int rober(int[]nums,int i, int n, int[]dp){
    //     if(n==i) return nums[i];
    //     if(i>n) return 0;
    //     if(dp[n]!=-1) return dp[n]; 
    //     int take=nums[n]+rober(nums,i, n-2,dp);
    //     int skip=rober(nums,i, n-1,dp);
    //     return dp[n]=Math.max(take,skip);
    // }
     private int rob(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        int len = end - start + 1;
        int[] dp = new int[len];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], nums[start + i] + dp[i - 2]);
        }
        return dp[len - 1];
    }
    public int rob(int[] nums) {
        // int n=nums.length;
        // if(n==1) return nums[0];
        // if(n==2) return Math.max(nums[0], nums[1]);
        // return Math.max(rober(nums,1,n-1),rober(nums,0,n-2));

        // int n=nums.length;
        // if(n==1) return nums[0];
        // if(n==2) return Math.max(nums[0], nums[1]);
        // int []dp1=new int[n];
        // Arrays.fill(dp1,-1);
        // int []dp2=new int[n];
        // Arrays.fill(dp2,-1);
        // return Math.max(rober(nums,1,n-1,dp1),rober(nums,0,n-2,dp2));

        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        int []dp=new int[n];
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));


        // int n=nums.length;
        // if(n==1) return nums[0];
        // if(n==2) return Math.max(nums[0], nums[1]);
        // int a=nums[0];
        // int b=Math.max(nums[0], nums[1]);
        // for(int i=2;i<n;i++){
        //     int c=b;
        //     b=Math.max(b, a+nums[i]);
        //     a=c;
        // }
        // return b;

    }
}