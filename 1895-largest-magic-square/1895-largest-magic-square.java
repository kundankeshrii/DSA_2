class Solution {
    public int largestMagicSquare(int[][] grid) {
         int n=grid.length;int m=grid[0].length;
         int[][] row=new int[n][m+1];
         int[][] col=new int[n+1][m];
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                row[i][j+1]=row[i][j]+grid[i][j];
                col[i+1][j]=col[i][j]+grid[i][j];
            }
         }
         int maxSize=Math.min(n,m);
         for(int size=maxSize;size>=2;size--){
            for(int i=0;i+size<=n;i++){
                for(int j=0;j+size<=m;j++){
                    if(isMagic(grid,row,col,i,j,size)){
                        return size;
                    }
                }
            }
         }
         return 1;
    }
    private boolean isMagic(int[][] grid,int[][] row,int[][] col,int r,int c,int size){
        int target=row[r][c+size]-row[r][c];
        for(int i=r;i<r+size;i++){
            if(row[i][c+size]-row[i][c]!=target) return false;
        }
        for(int j=c;j<c+size;j++){
            if(col[r+size][j]-col[r][j]!=target) return false;
        }
        int diag1=0,diag2=0;
        for(int i=0;i<size;i++){
            diag1+=grid[r+i][c+i];
            diag2+=grid[r+i][c+size-1-i];
        }
        return diag1==target && diag2==target;
    }
}