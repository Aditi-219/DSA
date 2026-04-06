public class Solution {
    int minResult;
    private void dfs(int[] stones, int index, int currentSum, int totalSum) {
        if (index == stones.length) {
            minResult = Math.min(minResult, Math.abs(totalSum - 2 * currentSum));
            return;
        }
        dfs(stones, index + 1, currentSum + stones[index], totalSum);
        dfs(stones, index + 1, currentSum, totalSum);
    }
    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0;
        for (int stone : stones) totalSum += stone;
        int target = totalSum / 2;
        boolean[][] dp = new boolean[stones.length + 1][target + 1];
        dp[0][0] = true;
        for(int i=1;i<=stones.length;i++){
            for(int j=0;j<=target;j++){
                dp[i][j] = dp[i - 1][j];
                if (j >= stones[i - 1]) dp[i][j] = dp[i][j] || dp[i - 1][j - stones[i - 1]];
            }
        }
        for (int j = target; j >= 0; j--) {
            if (dp[stones.length][j]) return totalSum - 2 * j;
        }
        return totalSum;
        
        
        // int totalSum = 0;
        // for (int stone : stones) totalSum += stone;
        // minResult = totalSum;
        // dfs(stones, 0, 0, totalSum);
        // return minResult;


        // int totalSum = 0;
        // for (int stone : stones) totalSum += stone;
        // int half = totalSum / 2;
        // boolean[] dp = new boolean[half + 1];
        // dp[0] = true;
        // for (int stone : stones)
        //     for (int j = half; j >= stone; j--)
        //         dp[j] = dp[j] || dp[j - stone];
        // for (int j = half; j >= 0; j--) {
        //     if (dp[j]) return totalSum - 2 * j;
        // }
        // return 0;
    }
}