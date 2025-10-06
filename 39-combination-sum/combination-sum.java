class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        backtrack(res,candidates,target,new ArrayList<>(),0,0);
        return res;
    }
    private void backtrack(List<List<Integer>> res, int[] nums, int target, List<Integer> curr,int sum,int start){
        if(sum==target){
            res.add(new ArrayList<>(curr));
            return;
        }
        if (sum > target) return;
        for(int i=start;i<nums.length;i++){
            sum+=nums[i];
            curr.add(nums[i]);
            backtrack(res,nums,target,curr,sum,i);
            sum -= nums[i];
            curr.remove(curr.size() - 1);
        }
    }
}