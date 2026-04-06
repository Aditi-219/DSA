class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int cost1 = costs[0] + dp[i + 1];

            int j = i;
            while (j < n && days[j] <= days[i] + 6) j++;
            int cost2 = costs[1] + dp[j];

            int k = i;
            while (k < n && days[k] <= days[i] + 29) k++;
            int cost3 = costs[2] + dp[k];

            dp[i] = Math.min(cost1, Math.min(cost2, cost3));
        }

        return dp[0];

        // return solve(days, costs, 0);

        // int[] dp = new int[days.length];
        // Arrays.fill(dp,-1);
        // return solve(days, costs, 0, dp);
    }
    private int solve(int[] days, int[] costs, int i, int[] dp) {
        if (i >= days.length) return 0;
        if (dp[i] != -1) return dp[i];
        int cost1 = costs[0] + solve(days, costs, i + 1, dp);
        int j = i;
        while (j < days.length && days[j] <= days[i] + 6) j++;
        int cost2 = costs[1] + solve(days, costs, j, dp);

        int k = i;
        while (k < days.length && days[k] <= days[i] + 29) k++;
        int cost3 = costs[2] + solve(days, costs, k, dp);

        return dp[i] = Math.min(cost1, Math.min(cost2, cost3));
    }
    private int solve(int[] days, int[] costs, int i) {
        if (i >= days.length) return 0;
        int cost1 = costs[0] + solve(days, costs, i + 1);

        int j = i;
        while (j < days.length && days[j] <= days[i] + 6) j++;
        int cost2 = costs[1] + solve(days, costs, j);

        int k = i;
        while (k < days.length && days[k] <= days[i] + 29) k++;
        int cost3 = costs[2] + solve(days, costs, k);

        return Math.min(cost1, Math.min(cost2, cost3));
    }
}