class Solution {
    public int longestPalindrome(String s) {
        Set<Character> oddChars = new HashSet<>();
        int length = 0;
        for (char c : s.toCharArray()) {
            if (oddChars.contains(c)) {
                oddChars.remove(c);
                length += 2;
            } else oddChars.add(c);
        }
        if (!oddChars.isEmpty()) length++;
        return length;
    }
}