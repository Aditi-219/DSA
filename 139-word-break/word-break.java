class Solution {
    // private boolean canBreak(String s, Set<String> wordSet, int start, int[]dp) {
    //     if (start == s.length()) return true;
    //     if(dp[start]!=0) return dp[start]==1;
    //     for (int end = start + 1; end <= s.length(); end++) {
    //         if (wordSet.contains(s.substring(start, end))) {
    //             if (canBreak(s, wordSet, end,dp)) {
    //                 dp[start]=1;
    //                 return true;
    //             }
    //         }
    //     }
    //     dp[start]=-1;
    //     return false;
    // }
    public boolean wordBreak(String s, List<String> wordDict) {
        // Set<String> wordSet = new HashSet<>(wordDict);
        // int[] dp=new int[s.length()+1];
        // return canBreak(s, wordSet, 0, dp);


        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String w : wordDict) {
                int start = i - w.length();
                if (start >= 0 && dp[start] && s.substring(start, i).equals(w)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];        
    }
}