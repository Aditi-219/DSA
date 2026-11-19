class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc=1, dec=1;
        int maxinc=0, maxdec=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]>nums[i]) inc++;
            else{
                maxinc=Math.max(maxinc,inc);
                inc=1;
            }
            if(nums[i+1]<nums[i]) dec++;
            else{
                maxdec=Math.max(maxdec,dec);
                dec=1;
            }
        }
        maxinc=Math.max(maxinc,inc);
        maxdec=Math.max(maxdec,dec);
        return Math.max(maxinc,maxdec);
    }
}