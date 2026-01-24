class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] f : flights) {
            graph.get(f[0]).add(new int[]{f[1], f[2]});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, src, 0}); //stopsTaken, node, costSoFar
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int stops = curr[0];
            int node = curr[1];
            int cost = curr[2];
            if (stops > k) continue;
            for (int[] edge : graph.get(node)) {
                int nextNode = edge[0];
                int price = edge[1];
                int newCost = cost + price;
                if (newCost < dist[nextNode]) {
                    dist[nextNode] = newCost;
                    q.offer(new int[]{stops + 1, nextNode, newCost});
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}