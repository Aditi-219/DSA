class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=0;
        for(int num:nums) sum+=num;
        int target=sum-x;
        if (target == 0) return nums.length;
        if (target < 0) return -1;
        int currSum=0,left=0,max=-1;
        for(int right=0;right<nums.length;right++){
            currSum+=nums[right];
            while(currSum>target)currSum-=nums[left++];
            if(currSum==target)max=Math.max(max,right-left+1);
            System.out.println(max);
        }
        return max==-1?-1:nums.length-max;
    }
}