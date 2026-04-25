class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++) graph.add(new ArrayList<>());
        for(int time[]:times){
            graph.get(time[0]).add(new int[]{time[1],time[2]});
        }
        int []dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<int[]>queue=new PriorityQueue<>((a,b)->a[0]-b[0]);
        queue.add(new int[]{0,k});
        while(!queue.isEmpty()){
            int arr[]=queue.poll();
            int time=arr[0];
            int node=arr[1];
            if(time>dist[node]) continue;
            for(int[] edge: graph.get(node)){
                if(time+edge[1]<dist[edge[0]]){
                    dist[edge[0]]=time+edge[1];
                    queue.add(new int[]{time+edge[1],edge[0]});
                }
            }
        }
        int res=0;
        for(int i = 1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res, dist[i]);
        }
        return res;
    }
}