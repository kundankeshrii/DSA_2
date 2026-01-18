class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds=new DisjointSet(n);
        int cntExtra=0;
        int m=connections.length;
        for(int i=0;i<m;i++){
            int u=connections[i][0];
            int v=connections[i][1];
            if(ds.findUPar(u)==ds.findUPar(v)){
                cntExtra++;
            }else{
                ds.unionBySize(u,v);
            }
        }
        int cntC=0;
        for(int i=0;i<n;i++){
            if(ds.parent.get(i)==i) cntC++;
        }
        int ans=cntC-1;
        if(cntExtra>=ans) return ans;
        return -1;
    }
}
class DisjointSet{
    List<Integer> rank,parent,size;
    public DisjointSet(int n){
        List<Integer> rank=new ArrayList<>(n+1);
        Collections.fill(rank,0);
        parent=new ArrayList<>(n+1);
        size=new ArrayList<>(n+1);
        for(int i=0;i<=n;i++){
        parent.add(i);
        size.add(1);
        }
    }
    public int findUPar(int node){
        if(node==parent.get(node)) return node;
        parent.set(node,findUPar(parent.get(node)));
        return parent.get(node);
    }
    public void unionByRank(int u,int v){
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        if(ulp_u==ulp_v) return;
        if(rank.get(ulp_u)<rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }else{
            parent.set(ulp_v,ulp_u);
            rank.set(ulp_u,rank.get(ulp_u)+1);
        }
    }
    public void unionBySize(int u,int v){
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        if(ulp_u==ulp_v) return;
        if(size.get(ulp_u)<size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
        }else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}