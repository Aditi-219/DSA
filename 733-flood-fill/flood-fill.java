class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) {
            dfs(image, sr, sc, color, newColor);
        }
        return image;
    }
    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        image[r][c] = newColor;
        for (int[] dir : new int[][]{{1,0},{0,1},{-1,0},{0,-1}}) {
            int newRow = r + dir[0];
            int newCol = c + dir[1];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && image[newRow][newCol] == color) {
                dfs(image, newRow, newCol, color, newColor);
            }
        }
    }
}