class Solution {
    private int fibo(int[] arr, int n){
        if (n<=0) return 0;
        if (n==1) return 1;
        if(arr[n]!=-1) return arr[n];
        return arr[n]=fibo(arr,n-1)+fibo(arr,n-2);
    }
    public int fib(int n) {
        if (n==0) return 0;
        if(n==1) return 1;
        int[] arr=new int[n+1];
        Arrays.fill(arr,-1);
        arr[0]=0;arr[1]=1;
        return fibo(arr,n);
        // if (n<=0) return 0;
        // if (n==1) return 1;
        // return fib(n-1)+fib(n-2);
        // if(n==0) return 0;
        // int prev2=0;
        // int prev1=1;
        // for(int i=2;i<=n;i++){
        //     int curr=prev1+prev2;
        //     prev2=prev1;
        //     prev1=curr;
        // }
        // return prev1;
    }
}