class Solution {
    public int jump(int[] nums) {
        if (nums.length < 2) return 0;
        int jumps = 0, maxReach = 0, currentEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = maxReach;
            }
            if (currentEnd >= nums.length - 1) {
                return jumps;
            }
        }
        return jumps;
    }
}