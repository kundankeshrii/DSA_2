class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
         int n=nums.length;
         int[] arr=new int[n-k+1];
         int[] freq=new int[101];
         for(int i=0;i<k;i++){
            freq[nums[i]+50]++;
         }
         int idx=0;
         arr[idx++]=findBeauty(freq,x);
         for(int r=k;r<n;r++){
            freq[nums[r]+50]++;//right value
            freq[nums[r-k]+50]--;//left value
            arr[idx++]=findBeauty(freq,x);
         }
        return arr;
    }
    private int findBeauty(int[] mpp,int x){
        int cnt=0;
        for(int i=0;i<101;i++){
            cnt+=mpp[i];
            if(cnt>=x){
               return Math.min(i-50,0);
            }
        }
        return 0;
    }
}

/*
approach 1:-Brute force
approach 2:-
k size ka window fix karo and uske corresponding freq[] me daal do sab element ko
ans[] banao and insert the value return as per condition by findBeauty
aab tak size k ke liye kara tha aab sab ke liye karo by using sliding window technique
freq[] maintain karte raho har time e.g left se delete karna and right wale value ko insert karna 
ans[] maintain and return karna 
 */