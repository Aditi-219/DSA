public class Solution {
    public int orangesRotting(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2) queue.add(new int[]{i,j});
                if(grid[i][j]==1) fresh++;
            }
        }
        int min=0;
        while(!queue.isEmpty() && fresh>0){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[]pos=queue.poll();
                int r=pos[0];
                int c=pos[1];
                for(int [] arr:new int[][]{{1,0},{-1,0},{0,1},{0,-1}}){
                    int newr=r+arr[0];
                    int newc=c+arr[1];
                    if(newr<0 || newc<0 || newr>=row || newc>=col) continue;
                    if(grid[newr][newc]==1){ 
                        grid[newr][newc]=2;
                        queue.add(new int[]{newr,newc});
                        fresh--;
                    }
                }
            }
            min++;
        }
        if(fresh > 0) return -1;
        return min;
    }
}