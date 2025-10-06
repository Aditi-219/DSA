class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        backtracking(nums,res,new ArrayList<>(), new boolean[nums.length]);
        return res;
    }
    private void backtracking(int[]nums, List<List<Integer>> res, List<Integer> curr, boolean[] used){
        if(curr.size()==nums.length) res.add(new ArrayList<>(curr));
        else{
                for(int i=0;i<nums.length;i++){
                if(used[i]) continue;
                used[i]=true;
                curr.add(nums[i]);
                backtracking(nums,res,curr,used);
                used[i]=false;
                curr.remove(curr.size()-1);
            }
        }
    }
}