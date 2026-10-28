class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int minAbs = Integer.MAX_VALUE;
        int negatives = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sum += Math.abs(num);
                minAbs = Math.min(minAbs, Math.abs(num));
                if (num < 0) negatives++;
            }
        }
        return negatives % 2 == 0 ? sum : sum - 2L * minAbs;
    }
}