class Solution {
    private static final String[] Keypad={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if(digits==null || digits.length()==0) return res;
        backtrack(res,digits,new StringBuilder(),0);
        return res;
    }
    private void backtrack(List<String> res, String digits, StringBuilder st,int index){
        if (index==digits.length()){
            res.add(st.toString());
            return;
        }
        String letters=Keypad[digits.charAt(index)-'0'];
        for(char letter:letters.toCharArray() ){
            st.append(letter);
            backtrack(res,digits,st,index+1);
            st.deleteCharAt(st.length()-1);
        }
    }
}