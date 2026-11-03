class Solution {
    public int minMoves(int[] nums) {
        int moves=0;
        int max=0;
        for(int num:nums){
            max=Math.max(max,num);
        }
        for(int num:nums){
            if(num<max){
            moves+=max-num;
            }
        }
    return moves;
    }
}