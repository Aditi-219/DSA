public class Solution {
    public int longestStrChain(String[] words) {
        // Arrays.sort(words,(a,b)-> a.length()-b.length());  
        // int[]dp=new int[words.length];
        // Arrays.fill(dp,1);
        // for(int i=1;i<words.length;i++){
        //     for(int j=0;j<i;j++){
        //         if(words[i].length()==words[j].length()) continue;
        //         String str1=words[i];
        //         String str2=words[j];
        //         for(int k=0;k<str1.length();k++){
        //             String sub= str1.substring(0,k)+str1.substring(k+1);
        //             if(sub.equals(str2)) dp[i]=Math.max(dp[i],dp[j]+1);
        //         }
        //     }
        // }
        // int res=0;
        // for(int num:dp)res=Math.max(res,num);
        // return res;


        Arrays.sort(words, (a, b) -> a.length() - b.length());
        HashMap<String, Integer> dp = new HashMap<>();
        int max_chain = 0;
        for (String word : words) {
            dp.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                String prev_word = word.substring(0, i) + word.substring(i + 1);
                if (dp.containsKey(prev_word)) {
                    dp.put(word, Math.max(dp.get(word), dp.get(prev_word) + 1));
                }
            }
            max_chain = Math.max(max_chain, dp.get(word));
        }
        return max_chain;
    }
}