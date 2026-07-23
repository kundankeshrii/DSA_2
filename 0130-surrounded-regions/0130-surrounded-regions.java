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
    private void dfs(int r,int c,int[][] vis,char[][] board){
        vis[r][c]=1;
        int m=board.length;
        int n=board[0].length;
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0 && nr<m && nc>=0 && nc<n && vis[nr][nc]==0 && board[nr][nc]=='O'){
                dfs(nr,nc,vis,board);
            }
        }
    }
}