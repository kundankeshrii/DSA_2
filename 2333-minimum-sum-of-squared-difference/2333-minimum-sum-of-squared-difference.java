class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n=nums1.length;
        long k=(long)k1+k2;
        int[]arr=new int[100001];
        for(int i=0;i<n;i++){
            int freq=Math.abs(nums1[i]-nums2[i]);
            arr[freq]++;
        }

        int i=arr.length-1;
        while(k>0 && i>=1){
            int cntOps=(int)Math.min(k,(long)arr[i]);
            arr[i]-=cntOps;
            arr[i-1]+=cntOps;
            k=k-cntOps;
            i--;
        }
        long ans=0;
        for(int l=1;l<arr.length;l++){
            ans+=(long)arr[l]*l*l;
        }
        return ans;
    }
}