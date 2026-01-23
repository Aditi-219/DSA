class Solution {
    public int numIslands(char[][] grid) {
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    grid[i][j] = '0';
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }
    void dfs(char[][]grid, int i, int j){
        int rows=grid.length;
        int cols=grid[0].length;
        for(int []dir:new int[][]{{0,1},{1,0},{-1,0},{0,-1}}){
            int newR=i+dir[0];
            int newC=j+dir[1];
            if(newR>=0 && newR<rows && newC>=0 && newC<cols && grid[newR][newC]=='1'){
                grid[newR][newC]='0';
                dfs(grid,newR,newC);
            }
        }
    }
}