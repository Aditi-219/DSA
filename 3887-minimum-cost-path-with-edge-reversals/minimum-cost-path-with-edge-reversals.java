class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++) graph.add(new ArrayList<>());
        for(int edge[]:edges){
            graph.get(edge[0]).add(new int[]{edge[1],edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0],edge[2]*2});
        }
        int []dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        PriorityQueue<int[]>queue=new PriorityQueue<>((a,b)->a[0]-b[0]);
        queue.add(new int[]{0,0});
        while(!queue.isEmpty()){
            int arr[]=queue.poll();
            int cost=arr[0];
            int node=arr[1];
            if(cost>dist[node]) continue;
            for(int[] edge: graph.get(node)){
                if(cost+edge[1]<dist[edge[0]]){
                    dist[edge[0]]=cost+edge[1];
                    queue.add(new int[]{cost+edge[1],edge[0]});
                }
            }
        }
        return dist[n-1]==Integer.MAX_VALUE? -1 : dist[n-1];
    }
}