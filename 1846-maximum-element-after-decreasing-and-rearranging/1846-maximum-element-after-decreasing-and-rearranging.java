class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int m=1;
        int n=arr.length;
        Arrays.sort(arr);
        
        for(int i=1;i<n;i++){
            if(arr[i]>m){
                m+=1;
            }
        }
           
            
        return m;
    }
}