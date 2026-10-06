class Solution {
    public int maxRepeating(String sequence, String word) {
        int ans=0;
        String temp=word;
        while(sequence.contains(temp)){
            ans++;
            temp+=word;
        }
        return ans;
    }
}