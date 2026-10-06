class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[]prev=new int[n+1];
        for(int idx=n-1;idx>=0;idx--){
            int[]curr=new int[n+1];
            for(int prevIdx=idx-1;prevIdx>=-1;prevIdx--){
                int notTake=0+prev[prevIdx+1];
                int take=0;
                if(prevIdx==-1 || nums[idx]>nums[prevIdx]){
                    take=1+prev[idx+1];
                }
                curr[prevIdx+1]= Math.max(take,notTake);
            }
            prev=curr;
        }
        return prev[0];
    }
}