class Solution {
    public int totalNQueens(int n) {
        return backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), n);
    }

    private int backtrack(int row, Set<Integer> cols, Set<Integer> posdiags, Set<Integer> negdiags, int n) {
        if (row == n) return 1; // found a valid placement

        int count = 0;
        for (int col = 0; col < n; col++) {
            int posdiag = row + col;
            int negdiag = row - col;

            if (cols.contains(col) || posdiags.contains(posdiag) || negdiags.contains(negdiag))
                continue; // conflict, skip

            // place queen
            cols.add(col);
            posdiags.add(posdiag);
            negdiags.add(negdiag);

            count += backtrack(row + 1, cols, posdiags, negdiags, n);

            // backtrack
            cols.remove(col);
            posdiags.remove(posdiag);
            negdiags.remove(negdiag);
        }
        return count;
    }
}
