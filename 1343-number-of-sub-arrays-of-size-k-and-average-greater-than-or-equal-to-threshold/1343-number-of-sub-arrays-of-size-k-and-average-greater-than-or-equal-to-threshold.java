class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n=arr.length;
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        //core concept 
        //avg=sum/k  ...sum/k>=threshold
        // .ie sum>=threshold*k

        int cnt=0;
        if(sum>=threshold*k){
                cnt++;
            }
        for(int i=k;i<n;i++){
            sum=sum-arr[i-k]+arr[i];
            if(sum>=threshold*k) cnt++;
            }
        return cnt;
    }
}