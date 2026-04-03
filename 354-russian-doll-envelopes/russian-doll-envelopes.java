public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n=envelopes.length;
        if (n == 0) return 0;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1]; 
            return a[0] - b[0];
        });

        // int ans=0;
        // int []dp=new int[n];
        // Arrays.fill(dp,1);
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<i;j++){
        //         if(envelopes[j][1]<envelopes[i][1]){
        //             dp[i]=Math.max(dp[i],1+dp[j]);
        //         }
        //     }
        //     ans=Math.max(ans,dp[i]);
        // }
        // return ans;


        int[] tails = new int[n];
        int size = 0;
        for (int[] envelope : envelopes) {
            int height = envelope[1];
            int lo = 0, hi = size;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (tails[mid] < height) lo = mid + 1;
                else hi = mid;
            }
            tails[lo] = height;
            if (lo == size) size++;
        }

        return size;
    }
}