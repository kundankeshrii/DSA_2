class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(m-1,n-1,grid,dp);
    }
    private int fun(int i,int j,int[][]grid,int[][]dp){
        int m=grid.length;
        int n=grid[0].length;

        if(i==0 && j==0) return grid[0][0];
        if(i<0 ||  j<0) return Integer.MAX_VALUE;
        if(dp[i][j]!=-1 ) return dp[i][j];

        int up=Integer.MAX_VALUE;
        int left=Integer.MAX_VALUE;

        if(i>0) up=grid[i][j]+fun(i-1,j,grid,dp);
        if(j>0) left=grid[i][j]+fun(i,j-1,grid,dp);
        
        dp[i][j]= Math.min(left,up);
        return dp[i][j];
    }
}