import java.util.*;

class Solution {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        // Step 1: Convert board to 1D mapping
        int[] move = new int[n * n + 1];
        Arrays.fill(move, -1);

        int cell = 1;
        boolean leftToRight = true;

        for (int row = n - 1; row >= 0; row--) {
            if (leftToRight) {
                for (int col = 0; col < n; col++) {
                    if (board[row][col] != -1) {
                        move[cell] = board[row][col];
                    }
                    cell++;
                }
            } else {
                for (int col = n - 1; col >= 0; col--) {
                    if (board[row][col] != -1) {
                        move[cell] = board[row][col];
                    }
                    cell++;
                }
            }
            leftToRight = !leftToRight;
        }

        // Step 2: BFS for shortest path
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];

        queue.offer(1);
        visited[1] = true;

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int curr = queue.poll();

                if (curr == n * n) {
                    return level;
                }

                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if (next > n * n) break;

                    int destination = (move[next] != -1) ? move[next] : next;

                    if (!visited[destination]) {
                        visited[destination] = true;
                        queue.offer(destination);
                    }
                }
            }
            level++;
        }

        return -1;
    }
}