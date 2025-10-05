class Solution {
public int[] assignTasks(int[] servers, int[] tasks) {
    int n = servers.length;
    int m = tasks.length;
    int[] result = new int[m];

    // PriorityQueue for available and busy servers
    PriorityQueue<int[]> available = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));
    PriorityQueue<int[]> busy = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]));

    for (int i = 0; i < n; i++) {
        available.offer(new int[] {servers[i], i});
    }

    int time = 0;
    for (int i = 0; i < m; i++) {
        time = Math.max(time, i);

        // Release servers that are no longer busy
        while (!busy.isEmpty() && busy.peek()[0] <= time) {
            int[] server = busy.poll();
            available.offer(new int[] {servers[server[1]], server[1]});
        }

        // If no servers are available, jump the time to the next server free time
        if (available.isEmpty()) {
            time = busy.peek()[0];
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                int[] server = busy.poll();
                available.offer(new int[] {servers[server[1]], server[1]});
            }
        }

        int[] server = available.poll();
        result[i] = server[1];
        busy.offer(new int[] {time + tasks[i], server[1]});
    }

    return result;
}
}