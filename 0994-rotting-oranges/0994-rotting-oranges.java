class Pair{
    int row;
    int col;
    int tm;
    Pair(int r,int c,int t){
        this.row=r;
        this.col=c;
        this.tm=t;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<Pair>q=new LinkedList<>();
        int[][] vis=new int[m][n];
        int cntFresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1) cntFresh++;
            }
        }
        int[]deltaRow={-1,0,1,0};
        int[]deltaCol={0,1,0,-1};
        int tm=0;
        int cnt=0;
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().tm;
            tm=Math.max(tm,t);
            q.remove();
            for(int i=0;i<4;i++){
                int nr=r+deltaRow[i];
                int nc=c+deltaCol[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n && vis[nr][nc]!=2 && grid[nr][nc]==1 ){
                    q.add(new Pair(nr,nc,t+1));
                    vis[nr][nc]=2;
                    cnt++;
                }
            }
        }
        if(cnt!=cntFresh) return -1;
        return tm;
    }
}