class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        long sum=0;
        int cnt=0;
        int delete=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum+=Math.abs(matrix[i][j]);
                if(matrix[i][j]<0) {
                    cnt++;
                }
                delete=Math.min(delete,Math.abs(matrix[i][j]));
            }
        }
        if(cnt%2==0) return sum;
        return sum-(2L*delete);
    }
}