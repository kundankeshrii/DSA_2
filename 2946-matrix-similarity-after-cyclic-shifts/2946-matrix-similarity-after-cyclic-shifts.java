class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m=mat.length;
        int n=mat[0].length;
        k=k%n;
        if(k==0){
            return true;
        }
        int[][] temp=new int[m][n];
        for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
                temp[i][j]=mat[i][j];
             }
        }
        for(int i=0;i<m;i++){
            if(i%2==0){
                leftR(mat[i],k);
            }else{
                rightR(mat[i],k);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]!=temp[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    private void leftR(int[]nums,int k){
        int n=nums.length;
        k=k%n;
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
        reverse(nums,0,n-1);
    }
    private void rightR(int[]nums,int k){
        int n=nums.length;
        k=k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    private void reverse(int[] nums,int i,int j){
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
}