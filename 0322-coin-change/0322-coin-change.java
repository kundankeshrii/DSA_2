class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][]dp=new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=fun(n-1,amount,coins,dp);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    private int fun(int idx,int target,int[] coins,int[][] dp){
        if(idx==0){
            if(target%coins[0]==0) return target/coins[0];
            else return Integer.MAX_VALUE;
        }
        if(dp[idx][target]!=-1) return dp[idx][target];
        int notTake=0+fun(idx-1,target,coins,dp);
        int take=Integer.MAX_VALUE;
        if(coins[idx]<=target){
            int temp=fun(idx,target-coins[idx],coins,dp);
            if(temp!=Integer.MAX_VALUE){
                take=1+temp;
            }
        }
        return dp[idx][target]= Math.min(take,notTake);
        
    }
}