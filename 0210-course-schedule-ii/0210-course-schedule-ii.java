class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
     ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
     for(int i=0;i<numCourses;i++){
        adj.add(new ArrayList<>());
     }   
     for(int[] e:prerequisites){
        int u=e[1];//changed
        int v=e[0];
        adj.get(u).add(v);
     }
     int[] indegree=new int[numCourses];
     for(int i=0;i<numCourses;i++){
        for(int it:adj.get(i)){
            indegree[it]++;
        }
     }
     Queue<Integer>q=new LinkedList<>();
     for(int i=0;i<numCourses;i++){
        if(indegree[i]==0){
            q.add(i);
        }
     }
     int[] ans=new int[numCourses];
     int i=0;
     while(!q.isEmpty()){
        int node=q.poll();
        ans[i]=node;
        i++;
        for(int it:adj.get(node)){
            indegree[it]--;
            if(indegree[it]==0){
                q.add(it);
            }
        }
     }
    if(i==numCourses) return ans;
    return new int[]{};
    }
}
