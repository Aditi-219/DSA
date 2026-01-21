class Solution {
    int longestCycleLen = -1;
    private void dfsFindLongestCycle(int cycleLen,int node,int[] currentPath,boolean[] visited,int[] edges) {
        cycleLen++;
        currentPath[node] = cycleLen;
        visited[node] = true;
        int nbr = edges[node];
        if (nbr != -1) {
            if (!visited[nbr]) {
                dfsFindLongestCycle(cycleLen, nbr, currentPath, visited, edges);
            }
            else if (currentPath[nbr] != 0) {
                int currCycleLen = currentPath[node] - currentPath[nbr] + 1;
                longestCycleLen = Math.max(longestCycleLen, currCycleLen);
            }
        }
        currentPath[node] = 0;
    }
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        int[] currentPath = new int[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfsFindLongestCycle(0, i, currentPath, visited, edges);
            }
        }
        return longestCycleLen;
    }
}