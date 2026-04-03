public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[]dp=new int[n+1];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
            }
        }
        int ans=0;
        for(int num:dp) ans=Math.max(num,ans);
        return ans;



        // if (nums == null || nums.length == 0) return 0;
        // int[] dp = new int[nums.length];
        // Arrays.fill(dp, 1);        
        // int maxLength = 1;
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (nums[i] > nums[j]) {
        //             dp[i] = Math.max(dp[i], dp[j] + 1);
        //         }
        //     }
        //     maxLength = Math.max(maxLength, dp[i]);
        // }
        // return maxLength;
    }
}