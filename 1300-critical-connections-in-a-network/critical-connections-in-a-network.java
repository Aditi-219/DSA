class Solution {
    private int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] inTime = new int[n];
        int[] lowReachTime = new int[n];
        boolean[] vis = new boolean[n];
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, -1, inTime, lowReachTime, vis, adj, ans);
        return ans;
    }
    private void dfs(int node, int parent, int[]inTime, int[]lowReachTime, boolean[]vis, List<List<Integer>>adj, List<List<Integer>>ans){
        vis[node] = true;
        inTime[node] = lowReachTime[node] = timer++;
        for (Integer neighbor : adj.get(node)) {
            if (neighbor == parent) continue;
            if (!vis[neighbor]) {
                dfs(neighbor, node, inTime, lowReachTime, vis, adj, ans);
                lowReachTime[node] = Math.min(lowReachTime[node], lowReachTime[neighbor]);
                if (lowReachTime[neighbor] > inTime[node]) ans.add(Arrays.asList(node, neighbor));
            } 
            else {
                lowReachTime[node] = Math.min(lowReachTime[node], inTime[neighbor]);
            }
        }
    }
}