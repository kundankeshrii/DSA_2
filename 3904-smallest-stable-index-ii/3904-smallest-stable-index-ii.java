class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int suf=Integer.MAX_VALUE;
        int suffix[]=new int[n];
        int prefix[]=new int[n];
        for(int i=n-1;i>=0;i--){
            suffix[i]=Math.min(nums[i],suf);
            suf=suffix[i];
        }
        int pre=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            prefix[i]=Math.max(nums[i],pre);
            pre=prefix[i];
        }
        for(int i=0;i<n;i++){
            if(prefix[i]-suffix[i]<=k){
                return i;
            }
        }
        return -1;
    }
}