class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        // [0, 1, 3, 5, 6]
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int papers = n - i;
            if (citations[i] >= papers) return papers;
        }
        return 0;
    }
}