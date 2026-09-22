class Solution {
    public String getHint(String secret, String guess) {
        int A=0;
        int B=0;
        HashMap<Character,Integer> smap=new HashMap<>();
        HashMap<Character,Integer> gmap=new HashMap<>();
        for(char ch: secret.toCharArray()) smap.put(ch,smap.getOrDefault(ch,0)+1); 
        for(int i=0;i<secret.length();i++){
            char ch=guess.charAt(i);
            if(secret.charAt(i)==guess.charAt(i)){
                A++;
                smap.put(ch,smap.getOrDefault(ch,0)-1);
            }
            else{
                gmap.put(ch,gmap.getOrDefault(ch,0)+1);
            }
        }
        for(char key: gmap.keySet()){
            if(smap.containsKey(key)){
                B += Math.min(gmap.get(key), smap.get(key));
            }
        }
        String res=A+"A"+B+"B";
        return res;
    }
}