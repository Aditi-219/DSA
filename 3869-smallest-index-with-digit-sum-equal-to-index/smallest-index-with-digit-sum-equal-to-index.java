class Solution {
    private int sum(int n){
        int sum=0;
        while(n>0){
            int x=n%10;
            sum+=x;
            n/=10;
        }
        return sum;
    }

    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(i==sum(nums[i])) return i;
        }
        return -1;
    }
}