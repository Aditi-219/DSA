class Solution {
    private int solve(int i, int[]arr,int []dp){
        if(i==0) return 0;
        if(i==1) return arr[1];
        if(dp[i]!=-1) return dp[i];
        int take=arr[i]+solve(i-2,arr,dp);
        int skip=solve(i-1,arr,dp);
        return dp[i]=Math.max(take,skip);
    }
    public int deleteAndEarn(int[] nums) {
        int maxVal=0;
        for(int num:nums) maxVal=Math.max(maxVal,num);
        int [] arr=new int[maxVal+1];
        for(int num:nums) arr[num]+=num;
        int []dp=new int[maxVal+1];
        Arrays.fill(dp,-1);
        dp[0]=arr[0];dp[1]=arr[1];
        return solve(maxVal,arr,dp);
    }
}