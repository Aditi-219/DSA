class Server implements Comparable<Server>{
    int weightage;
    int index;
    int freeTime;
    public Server(int weightage,int index){
        this.weightage=weightage;
        this.index=index;
        this.freeTime=0;
    }
    // sorts free servers based on weightage, if tie, then sort by index (freeServers<>)
    @Override
    public int compareTo(Server other){
        if(this.weightage==other.weightage){
            return this.index-other.index;
        }
        return this.weightage-other.weightage;
    }

    //sorts busy servers based on freeTime,if tie, sort by weightage, if again tie, then sort by index (busyServers<>)
    public static Comparator<Server> sortByFreeTime = (a,b) ->{
        if(a.freeTime==b.freeTime){ 
            if(a.weightage==b.weightage){ 
                return a.index-b.index; 
            }
            return a.weightage-b.weightage;
        } 
        return a.freeTime-b.freeTime;
    };
}
class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n=servers.length;
        PriorityQueue<Server> freeServers=new PriorityQueue<>();
        PriorityQueue<Server> busyServers=new PriorityQueue<>(Server.sortByFreeTime);
        int ans[]=new int[tasks.length];

        for(int i=0;i<n;i++){
            freeServers.add(new Server(servers[i],i));
        }

        int time=0;
        for(int i=0;i<tasks.length;i++){
            time=Math.max(time,i);
            //remove all the servers which are completed their process 
            while(!busyServers.isEmpty() && busyServers.peek().freeTime<=time){
                Server server=busyServers.poll();
                server.freeTime=0;
                freeServers.add(server);
            }
            // if no servers are free , then remove the servers(When the freeTime is equal to the first busy server ) from the busyServers Queue and add it to freeServers
            if(freeServers.isEmpty()){
                time=busyServers.peek().freeTime;
                while(!busyServers.isEmpty() && busyServers.peek().freeTime<=time){
                    Server server=busyServers.poll();
                    server.freeTime=0;
                    freeServers.add(server);
                }
            }
            Server server=freeServers.poll();
            ans[i]=server.index;
            server.freeTime=tasks[i]+time;
            busyServers.add(server);
            
        }
        return ans;
    }
}