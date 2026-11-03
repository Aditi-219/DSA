class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            ans.add(new ArrayList<>());
        }
        for (int[] e : edges) graph[e[0]].add(e[1]);
        for (int i = 0; i < n; i++) dfs(i, i, graph, new boolean[n], ans);
        for (List<Integer> list : ans) Collections.sort(list);
        return ans;
    }
    void dfs(int parent, int node, List<Integer>[] graph,boolean[] visited, List<List<Integer>> ans) {
        visited[node] = true;
        for (int next : graph[node]) {
            if (!visited[next]) {
                ans.get(next).add(parent);
                dfs(parent, next, graph, visited, ans);
            }
        }
    }
}