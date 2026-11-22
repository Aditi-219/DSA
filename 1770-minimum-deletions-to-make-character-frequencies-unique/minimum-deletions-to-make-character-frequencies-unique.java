public class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(freqMap.values());
        int count = 0;
        while (maxHeap.size() > 1) {
            int top = maxHeap.poll();
            if (maxHeap.peek() != null && maxHeap.peek() == top && top != 0) {
                count++;
                maxHeap.add(top - 1);
            }
        }
        return count;
    }
}