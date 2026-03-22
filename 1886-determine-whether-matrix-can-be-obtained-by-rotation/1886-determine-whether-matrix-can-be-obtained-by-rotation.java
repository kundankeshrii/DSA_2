class Solution {
    int n;
    public void rotate(int[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=i;j<mat.length;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
        for(int i=0;i<mat.length;i++){
            int left=0; int right=mat.length-1;
            while(left<right){
                int temp=mat[i][left];
                mat[i][left]=mat[i][right];
                mat[i][right]=temp;
                left++;
                right--;
            }
          }
        }
    public boolean findRotation(int[][] mat, int[][] target) {
        n=mat.length;
        for(int col=0;col<=4;col++){
            boolean equal=true;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][j]!=target[i][j]){
                        equal=false;
                        break;
                    }
                }
                if(!equal){
                    break;
                }
            }
            if(equal){
                return true;
            }
            rotate(mat);
        }
        return false;
    }
}
