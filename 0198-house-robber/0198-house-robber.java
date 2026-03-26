class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[]dp=new int[n];
        Arrays.fill(dp,-1);
        int idx=n-1;
        return fun(nums,idx,dp);
    }
    private int fun(int[] nums,int idx,int[] dp){
        if(idx==0) return nums[idx];
        if(idx<0) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int pick=nums[idx]+fun(nums,idx-2,dp);
        int notPick=0+fun(nums,idx-1,dp);
        dp[idx]=Math.max(pick,notPick);
        return dp[idx];
    }
}