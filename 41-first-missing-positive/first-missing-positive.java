class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> map=new HashSet<>();
        int num=1;
        for(int i=0;i<nums.length;i++){
            map.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            if(map.contains(num)) num++;
            else return num;
        }
        return num;
    }
}