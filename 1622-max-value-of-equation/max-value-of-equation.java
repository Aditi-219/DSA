class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<int[]> deque = new LinkedList<>();
        int maxValue = Integer.MIN_VALUE;
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            while (!deque.isEmpty() && x - deque.peekFirst()[1] > k) deque.pollFirst();
            if (!deque.isEmpty()) maxValue = Math.max(maxValue, y + x + deque.peekFirst()[0]);
            while (!deque.isEmpty() && y - x >= deque.peekLast()[0]) deque.pollLast();
            deque.offerLast(new int[]{y - x, x});
        }
        return maxValue;
    }
}