class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        backtrack(res,s,new ArrayList(),0);
        return res;
    }
    private void backtrack(List<List<String>> res, String s, List<String> curr, int start){
        if (start==s.length()) res.add(new ArrayList(curr));
        for(int i=start;i<s.length();i++){
            String sub= s.substring(start,i+1);
            if(isPallindrome(sub)) {
                curr.add(sub);
                backtrack(res,s,curr,i+1);
                curr.remove(curr.size() - 1);
            }
        }
    }
    private boolean isPallindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}