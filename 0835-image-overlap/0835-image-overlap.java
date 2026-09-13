class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n=img1.length;
        int max=0;
        for(int i=(-n+1);i<n;i++){
            for(int j=(-n+1);j<n;j++){
                int ans= countOverlap(i,j,img1,img2);
                max=Math.max(max,ans);
                }  
            }
        return max;
    }
    private int countOverlap(int row,int col,int[][]img1,int[][]img2){
        int cnt=0;
        int n=img1.length;
        for(int i=0;i<img1.length;i++){
            for(int j=0;j<img2.length;j++){
                if(i+row<0 || j+col>=n || i+row>=n || j+col<0) continue;
                if(img1[i][j]==1 && img2[i+row][j+col]==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}