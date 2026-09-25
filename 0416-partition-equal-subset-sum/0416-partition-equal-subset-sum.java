class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int totalSum=0;
        for(int i:nums){
            totalSum+=i;
        }
        if(totalSum%2==1){
            return false;
        }else{
            return subsetSum(nums,totalSum/2);
        }
    }
    private boolean subsetSum(int arr[],int target){
        int n=arr.length;
        int[][] dp=new int[n][target+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(n-1,target,arr,dp);
    }
    private boolean fun(int idx,int target,int[]arr,int[][]dp){
        if(target==0) return true;
        if(idx==0) return arr[0]==target;
        if(dp[idx][target]!=-1) return dp[idx][target]==1;
        boolean notTake=fun(idx-1,target,arr,dp);
        boolean take=false;
        if(arr[idx]<=target){
            take=fun(idx-1,target-arr[idx],arr,dp);
        }
        boolean result=take||notTake;
        dp[idx][target]=result?1:0;
        return result;
    }
}