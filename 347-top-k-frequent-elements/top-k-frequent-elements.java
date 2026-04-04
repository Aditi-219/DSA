class Pair implements Comparable<Pair>{
    int freq;
    int n;

    Pair(int n,int freq){
        this.n=n;
        this.freq=freq;
        
    }

    public int compareTo(Pair p){
        if(this.freq==p.freq) return this.n - p.n;
        return this.freq - p.freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> min= new PriorityQueue<>();
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i:nums){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        for(int i:mp.keySet()){
            min.add(new Pair(i,mp.get(i)));
            if(min.size()>k)
                min.remove(min.peek());
        }
        int idx=0;
        int[] ans=new int[k];
        for(int j=0;j<k;j++){
            Pair m=min.remove();
            ans[idx++]=(m.n);    
        }
        return ans;
        
    }
}