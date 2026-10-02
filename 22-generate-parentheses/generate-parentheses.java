class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        backtrack(n,res,new StringBuilder(),0,0);
        return res;
    }
    private void backtrack(int n, List<String> res, StringBuilder curr,int open, int close){
        if(curr.length()==n*2 && open ==close) res.add(curr.toString());
        if(open<n) {
            curr.append("(");
            backtrack(n,res,curr,open+1,close);
            curr.deleteCharAt(curr.length()-1);
        }
        if(close<open) {
            curr.append(")");
            backtrack(n,res,curr,open,close+1);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}