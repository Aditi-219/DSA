class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n= rooms.size();
        int[] vis=new int[n];
        Arrays.fill(vis,0);
        dfs(0, vis, rooms);
        for(int i=0;i<n;i++) if(vis[i]==0) return false;
        return true;
    }
    private void dfs(int node, int[]vis, List<List<Integer>> graph){
        if(vis[node]==0){
            vis[node]=1;
            for(int room:graph.get(node)){
                dfs(room, vis, graph);
            }
        }
    }
}