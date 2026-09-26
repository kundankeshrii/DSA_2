class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][]dp=new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=fun(n-1,amount,coins,dp);
        return ans>=1e9?-1:ans;
    }
    private int fun(int idx,int target,int[] coins,int[][] dp){
        if(idx==0){
            if(target%coins[0]==0) return target/coins[0];
            else return (int)1e9;
        }
        if(dp[idx][target]!=-1) return dp[idx][target];
        int notTake=0+fun(idx-1,target,coins,dp);
        int take=Integer.MAX_VALUE;
        if(coins[idx]<=target){
            take=1+fun(idx,target-coins[idx],coins,dp);
        }
        return dp[idx][target]= Math.min(take,notTake);
        
    }
}