class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] pSum=new int[n][m];
        for(int j=0;j<m;j++){
            int sum=0;
            for(int i=0;i<n;i++){
                if(matrix[i][j]=='0') {
                    pSum[i][j]=0;
                    sum=0;
                }else{
                    sum++;
                pSum[i][j]=sum;
              }
            }
        }
            int maxArea=0;
            for(int i=0;i<n;i++){
                int area=lHistogram(pSum[i]);
                maxArea=Math.max(maxArea, area);
            }
            return maxArea;
    }
    private int lHistogram(int[] arr){
        Stack<Integer> st=new Stack<>();
        int nse;
        int pse;
        int maxArea=0;
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]>= arr[i]){
                int element=st.peek();
                st.pop();
                 nse=i;
                 pse=st.isEmpty() ? -1: st.peek();
                maxArea=Math.max(maxArea,(nse-pse-1)*arr[element]);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
             nse=arr.length;
        int element=st.peek();
        st.pop();
         pse=st.isEmpty()? -1 : st.peek();
        maxArea=Math.max(maxArea,(nse-pse-1)*arr[element]);
        }
        return maxArea;
    }
}