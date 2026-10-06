class Solution {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!isVowel(word.charAt(0))) word = word.substring(1) + word.charAt(0);
            word += "ma";
            for (int j = 0; j <= i; j++) word += "a";
            result.append(word);
            if (i != words.length - 1) result.append(" ");
        }
        return result.toString();
    }
    private boolean isVowel(char c) {
        return c=='a'||c=='e'||c=='i'|c=='o'||c=='u'||c =='A'||c=='E'||c=='I'||c =='O'||c=='U';
    }
}