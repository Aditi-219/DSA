class Solution {
    Set<String> ans = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        int leftRemove = 0;
        int rightRemove = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') leftRemove++;
            else if (c == ')') {
                if (leftRemove > 0) leftRemove--;
                else rightRemove++;
            }
        }
        dfs(s, 0, leftRemove, rightRemove, 0, new StringBuilder());
        return new ArrayList<>(ans);
    }
    private void dfs(String s, int index, int leftRemove, int rightRemove,int open, StringBuilder sb) {
        if (index == s.length()) {
            if (leftRemove == 0 && rightRemove == 0 && open == 0) ans.add(sb.toString());
            return;
        }
        char c = s.charAt(index);
        int len = sb.length();
        if (c == '(') {
            if (leftRemove > 0) dfs(s, index + 1, leftRemove - 1, rightRemove, open, sb); // Remove '('
            sb.append(c); // Keep '('
            dfs(s, index + 1, leftRemove, rightRemove, open + 1, sb);
            sb.setLength(len);
        }
        else if (c == ')') {
            if (rightRemove > 0) dfs(s, index + 1, leftRemove, rightRemove - 1, open, sb); // Remove ')'
            // Keep ')' only if there is a matching '('
            if (open > 0) {
                sb.append(c);
                dfs(s, index + 1, leftRemove, rightRemove, open - 1, sb);
                sb.setLength(len);
            }
        } 
        else {
            sb.append(c);
            dfs(s, index + 1, leftRemove, rightRemove, open, sb);
            sb.setLength(len);
        }
    }
}