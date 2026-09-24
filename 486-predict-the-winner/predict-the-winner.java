class Solution {
    private int predict(int[] nums, int st, int end) {
        if (st > end) return 0;
        int takeStart = nums[st] - predict(nums, st + 1, end);
        int takeEnd =nums[end] - predict(nums, st, end - 1);
        return Math.max(takeStart, takeEnd);
    }
    public boolean predictTheWinner(int[] nums) {
        return predict(nums, 0, nums.length - 1) >= 0;
    }
}