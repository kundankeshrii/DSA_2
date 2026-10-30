class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        
        List<List<int[]>>adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[]edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            adj.get(u).add(new int[]{v,w});
        }
        PriorityQueue<int[]>pq=new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[][] dist=new int[n][k+1];
        for(int[]row:dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        dist[0][1]=0;
        pq.add(new int[]{0,0,1});
        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            int wt=arr[0];
            int node=arr[1];
            int count=arr[2];
            if(wt>dist[node][count]) continue;
            if(node==n-1){
                 return wt;
            }
            for(int[]it:adj.get(node)){
                int adjNode=it[0];
                int weight=it[1];
                int newCnt=(labels.charAt(adjNode)==labels.charAt(node)) ? count+1:1;
                if(newCnt>k) continue;
                int newDist=weight+wt;
                if(newDist<dist[adjNode][newCnt]){
                    dist[adjNode][newCnt]=newDist;
                    pq.add(new int[]{newDist,adjNode,newCnt});
                }
            }

        }
        return -1;
    }
}