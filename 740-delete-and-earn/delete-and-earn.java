class Solution {
    // private int solve(int i, int[]arr,int []dp){
    //     if(i==0) return 0;
    //     if(i==1) return arr[1];
    //     if(dp[i]!=-1) return dp[i];
    //     int take=arr[i]+solve(i-2,arr,dp);
    //     int skip=solve(i-1,arr,dp);
    //     return dp[i]=Math.max(take,skip);
    // }
    public int deleteAndEarn(int[] nums) {
        int maxVal=0;
        for(int num:nums) maxVal=Math.max(maxVal,num);
        int [] arr=new int[maxVal+1];
        for(int num:nums) arr[num]+=num;

        int a=arr[0];int b=arr[1];
        for(int i=2;i<=maxVal;i++){
            int c=b;
            b=Math.max(arr[i]+a,b);
            a=c;
        }
        return b;

        // int []dp=new int[maxVal+1];
        // dp[0] = arr[0]; dp[1] = arr[1];
        // for(int i=2;i<=maxVal;i++){
        //     dp[i]=Math.max(dp[i-1],arr[i]+dp[i-2]);
        // }
        // return dp[maxVal];

        // return solve(maxVal,arr,dp);
    }
}