class Solution {
    private boolean canPartition(int[]nums, int i, int target){
        if(target==0) return true;
        if(i==nums.length || target<0) return false;
        return canPartition(nums,i+1,target-nums[i]) ||canPartition(nums,i+1,target);
    }
    private boolean canPartition(int[]nums, int i, int target,int[][]dp){
        if(target==0) return true;
        if(i==nums.length || target<0) return false;
        if(dp[i][target]!=-1) return dp[i][target]==1;
        boolean take=canPartition(nums,i+1,target-nums[i],dp);
        boolean notTake=canPartition(nums,i+1,target,dp);
        dp[i][target]=(take||notTake)?1:0;
        return take||notTake;
    }
    public boolean canPartition(int[] nums) {
        int totalSum=0;
        for(int num:nums) totalSum+=num;
        if (totalSum % 2 != 0) return false;
        int target=totalSum/2;
        int[][]dp=new int[nums.length][target+1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return canPartition(nums,0,target,dp);
        
        // int totalSum = 0;
        // for (int num : nums) totalSum += num;
        // if (totalSum % 2 != 0) return false;
        // int sum = totalSum / 2;
        // boolean[] dp = new boolean[sum + 1];
        // dp[0] = true;
        // for (int num : nums)
        //     for (int s = sum; s >= num; s--)
        //         dp[s] = dp[s] || dp[s - num];
        // return dp[sum];
    }
}