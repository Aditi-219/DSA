class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        grid[0][0] = 1;
        int distance = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int r = pos[0];
                int c = pos[1];
                if (r == n - 1 && c == n - 1) return distance;
                for (int[] d : new int[][]{{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}}){
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr < 0 || nc < 0 || nr >= n || nc >= n || grid[nr][nc] == 1) continue;
                    queue.add(new int[]{nr, nc});
                    grid[nr][nc] = 1;
                }
            }
            distance++;
        }
        return -1;
    }
}