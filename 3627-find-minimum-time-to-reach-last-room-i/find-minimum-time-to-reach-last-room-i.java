class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length, n = moveTime[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[][] efforts = new int[m][n];
        for (int[] row : efforts) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        efforts[0][0]=0;
        pq.offer(new int[]{0, 0, 0}); // time, row, col
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0], x = current[1], y = current[2];
            if(time>efforts[x][y]) continue;
            if (x == m - 1 && y == n - 1) return time;
            for (int[] dir:new int [][]{{1,0},{0,1},{-1,0},{0,-1}}) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    int nextTime = Math.max(time,moveTime[newX][newY])+1;
                    if (nextTime < efforts[newX][newY]) {
                        efforts[newX][newY] = nextTime;
                        pq.offer(new int[]{nextTime, newX, newY});
                    }
                }
            }
        }
        return -1;
    }
}