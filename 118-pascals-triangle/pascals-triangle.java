class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> previousRow = result.get(i - 1);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(previousRow.get(j - 1) + previousRow.get(j));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }
}