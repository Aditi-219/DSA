class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];

        q.offer(1);
        visited[1] = true;

        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            // One BFS level = one dice roll
            for (int i = 0; i < size; i++) {
                int curr = q.poll();

                if (curr == n * n) return moves;

                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if (next > n * n) continue;

                    int[] pos = getCoord(next, n);
                    int r = pos[0], c = pos[1];

                    if (board[r][c] != -1) {
                        next = board[r][c];
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    // Position → board coordinate
    private int[] getCoord(int num, int n) {
        int rowFromBottom = (num - 1) / n;
        int row = n - 1 - rowFromBottom;

        int col = (num - 1) % n;
        if (rowFromBottom % 2 == 1) {
            col = n - 1 - col;
        }

        return new int[]{row, col};
    }
}
