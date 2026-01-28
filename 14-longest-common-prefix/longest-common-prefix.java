class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String sb = strs[0];
        for(int i=1;i<strs.length;i++){
            int s=0;
            while(s<strs[i].length() && s<sb.length() && sb.charAt(s)==strs[i].charAt(s)) s++;
            sb=sb.substring(0,s);
            if (sb.isEmpty()) return "";
        }
        return sb;
    }
}