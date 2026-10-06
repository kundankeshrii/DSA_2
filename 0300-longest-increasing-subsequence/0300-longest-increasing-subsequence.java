class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[]dp=new int[n];
        Arrays.fill(dp,1);
        int maxi=1;
        for(int idx=0;idx<n;idx++){
            for(int prevIdx=0;prevIdx<idx;prevIdx++){
                if(nums[prevIdx]<nums[idx]){
                    dp[idx]=Math.max(1+dp[prevIdx],dp[idx]);
                }
            }
            maxi=Math.max(maxi,dp[idx]);
        }
        return maxi;     
    }
}