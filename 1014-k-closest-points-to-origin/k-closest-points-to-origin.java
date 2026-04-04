class Triplet implements Comparable<Triplet>{
    int dist;
    int x;
    int y;

    Triplet(int dist,int x,int y){
        this.dist=dist;
        this.x=x;
        this.y=y;
    }

    public int compareTo(Triplet t){
        return this.dist-t.dist;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<Triplet> max= new PriorityQueue<>(Collections.reverseOrder());
    for(int i=0;i<points.length;i++){
        int y=points[i][1];
        int x=points[i][0];
        int dist=x*x+y*y;
        max.add(new Triplet(dist,x,y));
        if(max.size()>k) max.remove(max.peek());
    }
    int [][] ans=new int[k][2];
    for(int i=0;i<k;i++){
        Triplet t=max.remove();
        ans[i][0]=t.x;
        ans[i][1]=t.y;
    }
    return ans;
      
    }
}