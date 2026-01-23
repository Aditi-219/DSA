 class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return image;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];
            for (int[] dir:new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}}) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];
                if (newRow >= 0 && newRow < rows &&newCol >= 0 && newCol < cols && image[newRow][newCol] == oldColor) {
                    image[newRow][newCol] = newColor;
                    q.offer(new int[]{newRow, newCol});
                }
            }
        }
        return image;
    }
}