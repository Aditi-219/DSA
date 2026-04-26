class Solution {
    private int delete(int[]arr, int n, int[]dp){
        if(n==0) return arr[0];
        if(n==1) return arr[1];
        if(dp[n]!=-1) return dp[n];
        int skip=delete(arr,n-1,dp);
        int keep=arr[n]+delete(arr,n-2,dp);
        return dp[n]=Math.max(skip,keep);
    }
    public int deleteAndEarn(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int num:nums) if(num>max) max=num;
        int []arr=new int [max+1];
        for(int num:nums) arr[num]+=num;
        int []dp=new int[max+1];
        Arrays.fill(dp,-1);
        return delete(arr,max,dp);
    }
}