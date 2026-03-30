class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==1) return 1;        
        if(s.length()<1) return 0;        

        Set<Character> set=new HashSet<>();
        int l=0;
        int r=0;
        int count=0;
        set.add(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                r++;
            }else{
                while(set.contains(s.charAt(i))){
                    set.remove(s.charAt(l));
                    l++;
                }
                set.add(s.charAt(i));
                r++;

            }
            count=Math.max(count,r-l+1);
            System.out.println(count);
        }
        return count;
    }
}