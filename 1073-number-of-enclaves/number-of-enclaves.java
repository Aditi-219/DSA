class Solution {
    private void dfs(int [][]grid,int i,int j,int row,int col){
        if(i<0 ||j<0 ||i>=row ||j>=col ||grid[i][j]==0) return;
        grid[i][j]=0;
        dfs(grid,i+1,j,row,col);
        dfs(grid,i-1,j,row,col);
        dfs(grid,i,j+1,row,col);
        dfs(grid,i,j-1,row,col);
    }
    public int numEnclaves(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row=grid.length;
        int col=grid[0].length;
        int cnt=0;
        for(int i=0;i<row;i++) {
            if (grid[i][0] == 1) dfs(grid,i,0,row,col);
            if (grid[i][col-1] == 1) dfs(grid,i,col-1,row,col);
        }
        for(int j=0;j<col;j++){
            if (grid[0][j] == 1) dfs(grid,0,j,row,col);
            if (grid[row-1][j] == 1) dfs(grid,row-1,j,row,col);
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1) cnt++;
            }
        }
        return cnt;
    }
}