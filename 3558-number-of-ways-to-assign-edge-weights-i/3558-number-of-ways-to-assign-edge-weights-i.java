class Solution {
    static final long MOD=1_000_000_007L;

    public int assignEdgeWeights(int[][] edges) {
        Map<Integer,List<Integer>>adj=new HashMap<>();
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.computeIfAbsent(u,k->new ArrayList<>()).add(v);
            adj.computeIfAbsent(v,k->new ArrayList<>()).add(u);

        }
        int depth=getMaxDepth(adj,1,0);
        int ans=(int)power(2,depth-1);
        return ans;
    }
    private int getMaxDepth(Map<Integer,List<Integer>>adj,int root,int parent){
        int maxDepth=0;
        for(int nbr:adj.getOrDefault(root,new ArrayList<>())){
            if(nbr==parent) continue;
            maxDepth=Math.max(maxDepth,getMaxDepth(adj,nbr,root)+1);
        }
        return maxDepth;
    }
    private long power(long a,long b){
        if(b==0) return 1;
        long half=power(a,b/2);
        long result=(half*half)%MOD;
        if(b%2==1){
            return (result*a)%MOD;
        }
        return result;
    }
}