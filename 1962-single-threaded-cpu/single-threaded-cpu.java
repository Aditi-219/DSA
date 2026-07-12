class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        // Store (enqueueTime, processingTime, originalIndex)
        int[][] sorted = new int[n][3];
        for (int i = 0; i < n; i++) {
            sorted[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }
        // Sort by enqueue time
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));
        // Min-heap: order by (processingTime, originalIndex)
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });
        int[] result = new int[n];
        int resultIdx = 0;
        int i = 0;
        long currentTime = 0;
        while (resultIdx < n) {
            // Push all tasks that have arrived by currentTime
            while (i < n && sorted[i][0] <= currentTime) {
                heap.offer(sorted[i]);
                i++;
            }
            if (heap.isEmpty()) {
                // No available tasks, jump to next arrival
                currentTime = sorted[i][0];
                while (i < n && sorted[i][0] <= currentTime) {
                    heap.offer(sorted[i]);
                    i++;
                }
            }
            // Process the task with shortest processing time
            int[] task = heap.poll();
            result[resultIdx++] = task[2];
            currentTime += task[1];
        }
        return result;
    }
}