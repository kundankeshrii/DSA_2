class Solution {
    public int closedIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis=new int[m][n];
        int cnt=0;
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(vis[row][col]==0 && grid[row][col]==0){
                    if(bfs(row,col,vis,grid)){
                        cnt++;
                    }
                }
            }
        }
        return cnt;


    }
    private boolean bfs(int row,int col,int[][] vis,int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        vis[row][col]=1;
        boolean closed=true;
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{row,col});
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int r=arr[0];
            int c=arr[1];
            if(r==0 || r==m-1 || c==0 || c==n-1){
                closed=false;
            }

            int[] dr={-1,0,1,0};
            int[] dc={0,1,0,-1};
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n && vis[nr][nc]==0 && grid[nr][nc]==0){
                    vis[nr][nc]=1;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return closed;
    }
}