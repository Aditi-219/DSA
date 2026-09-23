public class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;
            int slow = i, fast = getIndex(i, nums);
            while (nums[fast]*nums[slow]> 0 && nums[getIndex(fast,nums)]*nums[slow]>0){
                if (slow == fast) {
                    if (slow == getIndex(slow, nums)) break;
                    return true;
                }
                slow = getIndex(slow, nums);
                fast = getIndex(getIndex(fast, nums), nums);
            }
            slow = i;
            int val = nums[i];
            while (nums[slow] * val > 0) {
                int next = getIndex(slow, nums);
                nums[slow] = 0;
                slow = next;
            }
        }
        return false;
    }
    public int getIndex(int i, int[] nums) {
        int n = nums.length;
        int next = (i + nums[i]) % n;
        if (next < 0) next += n;
        return next;
    }
}