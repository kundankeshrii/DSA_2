class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis=new int[m][n];
        int cnt=0;
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
    private void bfs(int row,int col,int[][] vis,char[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        vis[row][col]=1;
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{row,col});
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int r=arr[0];
            int c=arr[1];

            int[] dr={-1,0,1,0};
            int[] dc={0,1,0,-1};
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n && vis[nr][nc]==0 && grid[nr][nc]=='1'){
                    vis[nr][nc]=1;
                    q.add(new int[]{nr,nc});
                }
            }
        }
    }
}