class Solution {
        public int swimInWater(int[][] grid) {
        int N = grid.length;
        boolean[][] visited = new boolean[N][N];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{grid[0][0], 0, 0}); // {water_level, x, y}
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], x = curr[1], y = curr[2];
            if (visited[x][y]) continue;
            visited[x][y] = true;
            if (x == N - 1 && y == N - 1) return time;
            for (int[] dir:new int [][]{{1,0},{0,1},{-1,0},{0,-1}}) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    pq.offer(new int[]{Math.max(time, grid[nx][ny]), nx, ny});
                }
            }
        }
        return -1;
    }
}