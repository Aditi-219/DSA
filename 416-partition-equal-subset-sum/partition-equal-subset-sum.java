class Solution {
    // private boolean canPartition(int[]nums, int i, int target){
    //     if(target==0) return true;
    //     if(i==nums.length || target<0) return false;
    //     return canPartition(nums,i+1,target-nums[i]) ||canPartition(nums,i+1,target);
    // }
    // private boolean canPartition(int[]nums, int i, int target,int[][]dp){
    //     if(target==0) return true;
    //     if(i==nums.length || target<0) return false;
    //     if(dp[i][target]!=-1) return dp[i][target]==1;
    //     boolean take=canPartition(nums,i+1,target-nums[i],dp);
    //     boolean notTake=canPartition(nums,i+1,target,dp);
    //     dp[i][target]=(take||notTake)?1:0;
    //     return take||notTake;
    // }
    public boolean canPartition(int[] nums) {
        // int totalSum=0;
        // for(int num:nums) totalSum+=num;
        // if (totalSum % 2 != 0) return false;
        // int target=totalSum/2;
        // boolean[][]dp=new boolean[nums.length][target+1];
        // dp[0][0] = true;
        // if (nums[0] <= target) dp[0][nums[0]] = true;
        // for(int i=1;i<nums.length;i++){
        //     for(int j=0;j<=target;j++){
        //         if(target==0) dp[i][j]=true;
        //         boolean take=(nums[i] <= j) ? dp[i - 1][j - nums[i]] : false;
        //         boolean notTake=dp[i-1][j];
        //         dp[i][j]=take||notTake;
        //     }
        // }        
        // return dp[nums.length-1][target];
        
        // int totalSum=0;
        // for(int num:nums) totalSum+=num;
        // if (totalSum % 2 != 0) return false;
        // int target=totalSum/2;
        // int[][]dp=new int[nums.length][target+1];
        // for (int[] row : dp) Arrays.fill(row, -1);
        // return canPartition(nums,0,target,dp);
        
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        if (totalSum % 2 != 0) return false;
        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for(int i=0;i<nums.length;i++){
            for (int j = target; j >= nums[i]; j--) {
                dp[j]=dp[j - nums[i]]||dp[j];
            }
        }  
        return dp[target];
    }
}