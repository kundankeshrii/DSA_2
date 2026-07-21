class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int cnt=0;
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                cnt++;
                dfs(isConnected,vis,i);
            }
        }
        return cnt;
    }
    private void dfs(int[][] isConnected,boolean[] vis,int i){
        vis[i]=true;
        for(int j=0;j<isConnected.length;j++){
            if(vis[j]==false && isConnected[i][j]==1){
                dfs(isConnected,vis,j);
            }
        }
    }
}