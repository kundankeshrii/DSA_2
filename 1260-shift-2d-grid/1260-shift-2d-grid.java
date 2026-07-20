class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int[] oneD=new int[m*n];
        int l=0;
        k=k%(m*n);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                oneD[l++]=grid[i][j];
            }
        }
        int len=oneD.length;
        reverse(oneD,0,len-1);
        reverse(oneD,0,k-1);
        reverse(oneD,k,len-1);
        l=0;
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<m;i++){
            List<Integer>temp=new ArrayList<>();
;            for(int j=0;j<n;j++){
                temp.add(oneD[l++]);
            }
            ans.add(temp);
        }
        return ans;


    }
    private void reverse(int[] arr,int s,int e){
        int n=arr.length;
        while(s<=e){
            int temp=arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;
            e--;
        }
    }
}