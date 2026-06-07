class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
         //Average==Sum/k and required==>  sum/k>=threshold i.e sum>=threshold
        int cnt=0;
        if(sum>=threshold*k){
            cnt++;
        }
        for(int i=k;i<arr.length;i++){
            sum=sum-arr[i-k]+arr[i];  //arr[i-k]===left wala element
                                        //arr[i]===current wala element
            if(sum>=threshold*k) cnt++;
        }
        return cnt;
    }
}