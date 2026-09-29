class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][]dp=new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(n-1,amount,coins,dp);
    }
    private int fun(int idx,int target,int arr[],int[][]dp){
        if(idx==0){
            if(target%arr[0]==0){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[idx][target]!=-1) return dp[idx][target];
        int notTake=fun(idx-1,target,arr,dp);
        int take=0;
        if(arr[idx]<=target){
            take=fun(idx,target-arr[idx],arr,dp);
        }
        return dp[idx][target]=notTake+take;
    }
}