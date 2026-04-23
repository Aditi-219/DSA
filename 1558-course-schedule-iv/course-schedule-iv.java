class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> graph=new ArrayList<>();
        int[] inDegree=new int[numCourses];
        boolean[][] prereq = new boolean[numCourses][numCourses];
        for(int i=0;i<numCourses;i++) graph.add(new ArrayList<>());
        for(int []arr: prerequisites){
            graph.get(arr[0]).add(arr[1]);
            prereq[arr[0]][arr[1]] = true;
            inDegree[arr[1]]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0) queue.add(i);
        }
        while(!queue.isEmpty()){
            int num=queue.poll();
            for(int nei:graph.get(num)){
                for (int i = 0; i < numCourses; i++) {
                    if (prereq[i][num]) prereq[i][nei] = true;
                }
                inDegree[nei]--;
                if(inDegree[nei]==0) queue.add(nei);
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            int u = query[0], v = query[1];
            ans.add(prereq[u][v]);
        }
        return ans;
    }
}