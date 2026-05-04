class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        HashMap<Integer,int[]>mpp=new HashMap<>();
        int rowCount[]=new int[m];
        int colCount[]=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                mpp.put(mat[i][j],new int[]{i,j});
            }
        }
        for(int k=0;k<arr.length;k++){
            int val=arr[k];
            int []pos=mpp.get(val);
            int r=pos[0];
            int c=pos[1];
            rowCount[r]++;
            colCount[c]++;
            if(rowCount[r]==n || colCount[c]==m) return k;

        }
        return -1;
    }
}