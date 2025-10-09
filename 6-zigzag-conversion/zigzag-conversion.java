class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;
        StringBuilder result = new StringBuilder();
        int cycle = 2 * (numRows - 1);
        for (int row = 0; row < numRows; row++) {
            for (int i = row; i < s.length(); i += cycle) {
                result.append(s.charAt(i));
                int middleCharIndex = i + cycle - 2 * row;
                if (row != 0 && row != numRows - 1 && middleCharIndex < s.length()) {
                    result.append(s.charAt(middleCharIndex));
                }
            }
        }
        return result.toString();
    }
}