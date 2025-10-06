class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        backTracking(candidates,target,res,0,new ArrayList<>());
        return res;   
    }
    private void backTracking(int[] cand,int target,List<List<Integer>> res,int start,List<Integer>curr){
        if(target==0) res.add(new ArrayList<>(curr));
        for(int i=start;i<cand.length;i++){
            if(cand[i]>target) continue;
            curr.add(cand[i]);
            backTracking(cand,target-cand[i],res,i,curr);
            curr.remove(curr.size()-1);
        }
    }
}