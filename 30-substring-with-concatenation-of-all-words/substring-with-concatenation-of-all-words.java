class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s.length() == 0 || words.length == 0 || words[0].length() == 0) return result;
        int wordLength=words[0].length();
        int totalLength=wordLength*words.length;
        Map<String,Integer> wordCount=new HashMap<>();
        for(String word: words){
            wordCount.put(word,wordCount.getOrDefault(word,0)+1);
        }
        for(int i=0;i<wordLength;i++){
            int left=i,count=0;
            Map<String,Integer> seenWord=new HashMap<>();
            for(int right=left;right<=s.length()-wordLength;right+=wordLength){
                String word=s.substring(right,right+wordLength);
                if(wordCount.containsKey(word)){
                    seenWord.put(word,seenWord.getOrDefault(word,0)+1);
                    count++;
                    while(seenWord.get(word)>wordCount.get(word)){
                        String leftWord = s.substring(left, left + wordLength);
                        seenWord.put(leftWord, seenWord.get(leftWord) - 1);
                        count--;
                        left+=wordLength;
                    }
                    if(count==words.length){
                        result.add(left);
                    }
                }else{
                    left=right+wordLength;
                    seenWord.clear();
                    count=0;
                }
            }
        }
        return result;
    }
}