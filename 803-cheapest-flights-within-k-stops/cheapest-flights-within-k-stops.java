class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph =new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int [] flight:flights){
            graph.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{src,0,0});
        while(!queue.isEmpty()){
            int arr[]=queue.poll();
            int node=arr[0];
            int cost=arr[1];
            int stop=arr[2];
            if(stop>k) continue;
            for(int[] flight:graph.get(node)){
                int nextNode=flight[0];
                int nextCost=flight[1];
                int newCost=cost+nextCost;
                if(newCost<dist[nextNode]){
                    dist[nextNode]=newCost;
                    queue.add(new int[]{nextNode,newCost,stop+1});
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE? -1 : dist[dst];
    }
}