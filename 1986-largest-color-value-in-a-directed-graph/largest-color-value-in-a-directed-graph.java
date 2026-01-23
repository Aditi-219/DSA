class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int ans = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[][] cnt = new int[n][26];
        int[] indegree = new int[n];
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int processed = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            processed++;
            int colorIndex = colors.charAt(node) - 'a';
            cnt[node][colorIndex]++;
            ans = Math.max(ans, cnt[node][colorIndex]);
            for (int nbr : graph.get(node)) {
                for (int c = 0; c < 26; c++)
                    cnt[nbr][c] = Math.max(cnt[nbr][c], cnt[node][c]);
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    q.offer(nbr);
                }
            }
            
        }
        return processed == n ? ans : -1;
    }
}