class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        int answer = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(weights, days, mid)) {
                answer = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return answer;
    }
    private boolean isPossible(int[] weights, int days, int capacity) {
        int currentWeight = 0;
        int requiredDays = 1;
        for (int weight : weights) {
            if (currentWeight + weight > capacity) {
                requiredDays++;
                currentWeight = 0;
            }
            currentWeight += weight;
        }
        return requiredDays <= days;
    }
}