class Solution {
    public int removeStones(int[][] stones) {
        DSU dsu = new DSU();
        Set<Integer> nodes = new HashSet<>();
        int OFFSET = 10001;
        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + OFFSET;
            dsu.union(row, col);
            nodes.add(row);
            nodes.add(col);
        }
        Set<Integer> parents = new HashSet<>();
        for (int node : nodes) {
            parents.add(dsu.findP(node));
        }
        return stones.length - parents.size();
    }
    class DSU {
        Map<Integer, Integer> parent = new HashMap<>();
        public int findP(int x) {
            if (!parent.containsKey(x)) parent.put(x, x);
            if (parent.get(x) != x) {
                parent.put(x, findP(parent.get(x)));
            }
            return parent.get(x);
        }
        public void union(int u, int v) {
            int pu = findP(u);
            int pv = findP(v);
            if (pu != pv) parent.put(pu, pv);
        }
    }
}