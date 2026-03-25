class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        long sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum+=grid[i][j];
            }
        }
        long rSum=0;
        long cSum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                rSum+=grid[i][j];
                }
                if(sum-rSum==rSum){
                    return true;
                }
        }
        for(int j=0;j<m-1;j++){
            for(int i=0;i<n;i++){
                cSum+=grid[i][j];
                }
                if(sum-cSum==cSum){
                    return true;
                }
        }
        return false;
    }
}