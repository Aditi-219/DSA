class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(candidates,target,res,0,new ArrayList<>());
        return res;   
    }
    private void backTracking(int[] cand,int target,List<List<Integer>> res,int start,List<Integer>curr){
        if(target==0) res.add(new ArrayList<>(curr));
        for(int i=start;i<cand.length;i++){
            if(cand[i]>target || (i>start && cand[i]==cand[i-1])) continue;
            curr.add(cand[i]);
            backTracking(cand,target-cand[i],res,i+1,curr);
            curr.remove(curr.size()-1);
        }
    }
}