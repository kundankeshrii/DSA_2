class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum=0;
        int cnt=0;
        int l=0;
        for(int r=0;r<arr.length;r++){
            sum+=arr[r];
            int avg=0;
            if(r-l+1==k){
               avg=sum/k;
               if(avg>=threshold){
                cnt++;
               }
            }
            if(r-l+1>k){
                sum-=arr[l];
                avg=sum/k;
                if(avg>=threshold){
                    cnt++;
                }
                l++;
            } 
        }
        return cnt;
    }
}