class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int[]res=new int[nums.length];
        for(int i=nums.length*2-1;i>=0;i--){
            int curr=nums[i%nums.length];
            while(!st.isEmpty() && st.peek()<=curr) st.pop();
            if(i<nums.length){
                if(st.isEmpty()) res[i]=-1;
                else res[i]=st.peek();
            }
            st.push(curr);
        }
        return res;
    }
}