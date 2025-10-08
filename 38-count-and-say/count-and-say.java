class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        String prev = countAndSay(n - 1); // recursive call
        StringBuilder sb = new StringBuilder();

        int count = 1;
        for (int i = 0; i < prev.length(); i++) {
            // check next character or end of string
            if (i + 1 < prev.length() && prev.charAt(i) == prev.charAt(i + 1)) {
                count++;
            } else {
                sb.append(count).append(prev.charAt(i));
                count = 1; // reset for next run
            }
        }
        return sb.toString();
    }
}
