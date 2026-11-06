class Solution {
    public int scoreOfString(String s) {
        int i =0,j=1;
        int sum = 0;
        while(j<s.length()) sum =sum +Math.abs(s.charAt(i++)-s.charAt(j++));
        return sum;
    }
}