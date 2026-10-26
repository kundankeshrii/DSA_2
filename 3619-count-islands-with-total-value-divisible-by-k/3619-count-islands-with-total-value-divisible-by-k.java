class Solution {
    public int countIslands(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis=new int[m][n];
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0 && grid[i][j]>0){
                    if(bfs(i,j,vis,grid)%(long)k==0){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
    private long bfs(int row,int col,int[][]vis,int[][]grid){
        int m=grid.length;
        int n=grid[0].length;
        vis[row][col]=1;
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{row,col});
        long sum=0;
        while(!q.isEmpty()){
            int[]arr=q.poll();
            int r=arr[0];
            int c=arr[1];
            sum+=(long)grid[r][c];
            

            int[]dr={-1,0,1,0};
            int[]dc={0,1,0,-1};
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if((nr>=0 && nr<m && nc>=0 && nc<n ) &&  grid[nr][nc]>0 && vis[nr][nc]==0){
                    q.add(new int[]{nr,nc});
                    vis[nr][nc]=1;
                }
            }
            
        }
        return sum;
    }
}