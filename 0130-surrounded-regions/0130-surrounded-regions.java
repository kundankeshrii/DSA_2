class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int[][] vis=new int[m][n];
        for(int j=0;j<n;j++){
            if(vis[0][j]==0 && board[0][j]=='O'){
                dfs(0,j,vis,board);
            }
            if(vis[m-1][j]==0 && board[m-1][j]=='O'){
                dfs(m-1,j,vis,board);
            }
        }
        for(int i=0;i<m;i++){
            if(vis[i][0]==0 && board[i][0]=='O'){
                dfs(i,0,vis,board);
            }
            if(vis[i][n-1]==0 && board[i][n-1]=='O'){
                dfs(i,n-1,vis,board);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0 && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
    private void dfs(int row,int col,int[][] vis,char[][] board){
        vis[row][col]=1;
        int m=board.length;
        int n=board[0].length;
        int dR[]={-1,0,1,0};
        int dC[]={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nR=row+dR[i];
            int nC=col+dC[i];
            if(nR>=0 && nR<m && nC>=0 && nC<n && vis[nR][nC]==0 && board[nR][nC]=='O'){
                dfs(nR,nC,vis,board);
            }
        }

    }
}