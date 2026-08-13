class Solution {
    public String mergeAlternately(String word1, String word2) {
        String res="";
        int i=0;
        int j=0;
        int m=word1.length();
        int n=word2.length();
        while(i<m && j<n){
            res+=word1.charAt(i++);
            res+=word2.charAt(j++);
        }
        if(j!=n) res+=word2.substring(j);
        if(i!=m) res+=word1.substring(i);
        return res;
    }
}