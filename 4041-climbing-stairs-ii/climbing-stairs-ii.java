class Solution {
    public int climbStairs(int n, int[] costs) {
        int prev3 = 0;
        int prev2 = 0;
        int prev1 = 0;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            int from1 = prev1 + costs[i] + 1;
            int from2 = prev2 + costs[i] + 4;
            int from3 = prev3 + costs[i] + 9;
            curr = Math.min(from1, Math.min(from2, from3));
            prev3 = prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}