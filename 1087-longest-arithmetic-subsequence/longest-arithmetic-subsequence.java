class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) dp[i] = new HashMap<>();
        int maxLen = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                int prev = dp[j].getOrDefault(diff, 1);
                int curr = prev + 1;
                dp[i].put(diff, curr);
                maxLen = Math.max(maxLen, curr);
            }
        }
        return maxLen;
    }
}