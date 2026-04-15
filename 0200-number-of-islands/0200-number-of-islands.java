class Pair{
    int first;
    int second;
    Pair(int row,int col){
        this.first=row;
        this.second=col;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int cnt=0;
        int[][] vis=new int[m][n];
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(vis[row][col]==0 && grid[row][col]=='1'){
                    cnt++;
                    bfs(row,col,vis,grid);
                }
            }
        }
        return cnt;
    }
    private void bfs(int row, int col,int[][]vis,char[][] grid){
        vis[row][col]=1;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(row,col));
        int m=grid.length;
        int n=grid[0].length;
        int dR[]={-1,0,1,0};
        int dC[]={0,1,0,-1};
        while(!q.isEmpty()){
            Pair val=q.poll();
            row=val.first;
            col=val.second;
            for(int i=0;i<4;i++){
                int nR=row+dR[i];
                int nC=col+dC[i];
                if(nR>=0 && nR<m && nC>=0 && nC<n && vis[nR][nC]==0 && grid[nR][nC]=='1'){
                    vis[nR][nC]=1;
                    q.add(new Pair(nR,nC));
                }
            }
        }

    }
}