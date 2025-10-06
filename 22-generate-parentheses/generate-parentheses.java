class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        backtracking(n,res,new StringBuilder(),0,0);
        return res;
    }
    private void backtracking(int n, List<String> res, StringBuilder st,int op,int cl){
        if(st.length()==n*2) res.add(st.toString());
        if(op<n){
            st.append('(');
            backtracking(n,res,st,op+1,cl);
            st.deleteCharAt(st.length()-1);
        }
        if(cl<op){
            st.append(')');
            backtracking(n,res,st,op,cl+1);
            st.deleteCharAt(st.length()-1);
        }
    }
}