class Solution {
    public int[] twoSum(int[] nums, int target) {
        int []arr={-1};
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int find=target-nums[i];
            if(map.containsKey(find) && map.get(find) != i){
                arr=new int[]{i,map.get(find)};
                return arr;
            }
            map.put(nums[i],i);
        }
        return arr; //res
    }
}